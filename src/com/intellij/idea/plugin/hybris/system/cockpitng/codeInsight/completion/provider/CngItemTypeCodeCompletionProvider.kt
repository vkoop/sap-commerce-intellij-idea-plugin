/*
 * This file is part of "SAP Commerce Developers Toolset" plugin for IntelliJ IDEA.
 * Copyright (C) 2019-2024 EPAM Systems <hybrisideaplugin@epam.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.system.cockpitng.codeInsight.completion.provider

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.idea.plugin.hybris.codeInsight.completion.provider.ItemTypeCodeCompletionProvider
import com.intellij.idea.plugin.hybris.common.HybrisConstants
import com.intellij.idea.plugin.hybris.system.cockpitng.codeInsight.lookup.CngLookupElementFactory
import com.intellij.idea.plugin.hybris.system.cockpitng.meta.CngWrappingType
import com.intellij.idea.plugin.hybris.system.cockpitng.model.config.Config
import com.intellij.idea.plugin.hybris.system.cockpitng.model.config.Context
import com.intellij.idea.plugin.hybris.system.type.codeInsight.lookup.TSLookupElementFactory
import com.intellij.idea.plugin.hybris.system.type.meta.TSMetaModelAccess
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSGlobalMetaClassifier
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSGlobalMetaEnum
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSGlobalMetaItem
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSMetaType
import com.intellij.psi.util.parentOfType
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlTag
import com.intellij.util.ProcessingContext
import com.intellij.util.xml.DomElement

class CngItemTypeCodeCompletionProvider : ItemTypeCodeCompletionProvider() {

    /**
     * In case of `context` tag and `type` or `parent` attribute code completion we have to boost other side values
     * for `type` we are boosting all children of the `parent` type
     * for `parent` we are boosting all extends of the `type` type
     */
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val element = parameters.position

        val currentAttribute = element.parentOfType<XmlAttribute>()
            ?.takeIf { it.localName == Context.TYPE || it.localName == Context.PARENT }
            ?: return super.addCompletions(parameters, context, result)
        val tag = currentAttribute.parentOfType<XmlTag>()
            ?.takeIf { it.localName == Config.CONTEXT }
            ?: return addTypeCompletions(parameters, context, result)

        val metaModelAccess = TSMetaModelAccess.getInstance(element.project)
        val currentAttributeName = currentAttribute.localName
        val anotherAttributeValue = getAnotherType(currentAttributeName, tag)
            ?.let { metaModelAccess.findMetaClassifierByName(it) }
            ?: return super.addCompletions(parameters, context, result)

        val allItems = metaModelAccess.getAllOf(TSMetaType.META_ITEM, TSMetaType.META_ENUM)

        val boostedItems = getBoostedItems(currentAttributeName, anotherAttributeValue, allItems)
            ?.takeIf { it.isNotEmpty() }
            ?.toSet()
            ?: return super.addCompletions(parameters, context, result)

        addContextSpecificCompletions(currentAttributeName, anotherAttributeValue, result, boostedItems, allItems)
    }

    private fun addTypeCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        super.addCompletions(parameters, context, result)

        CngWrappingType.entries
            .map { CngLookupElementFactory.buildWrappingType(it.type, it.presentation, it.tail) }
            .forEach { result.addElement(it) }
    }

    private fun addContextSpecificCompletions(
        currentAttributeName: String,
        anotherAttributeValue: TSGlobalMetaClassifier<out DomElement>,
        result: CompletionResultSet,
        boostedItems: Collection<TSGlobalMetaClassifier<*>>,
        allItems: Collection<TSGlobalMetaClassifier<*>>
    ) {
        val resultCaseInsensitive = result.caseInsensitive()

        boostedItems
            .mapNotNull {
                val typeText = when (currentAttributeName) {
                    Context.TYPE -> " child of ${anotherAttributeValue.name}"
                    Context.PARENT -> " parent of ${anotherAttributeValue.name}"
                    else -> null
                }
                when (it) {
                    is TSGlobalMetaItem -> TSLookupElementFactory.build(it)
                    is TSGlobalMetaEnum -> TSLookupElementFactory.build(it, it.name)
                    else -> null
                }
                    ?.withTypeIconRightAligned(true)
                    ?.withTypeText(typeText, true)
                    ?.withBoldness(true)
            }
            .map { PrioritizedLookupElement.withPriority(it, TSLookupElementFactory.PRIORITY_1_0) }
            .map { PrioritizedLookupElement.withGrouping(it, TSLookupElementFactory.GROUP_1) }
            .forEach { resultCaseInsensitive.addElement(it) }

        allItems
            .filterNot { boostedItems.contains(it) }
            .mapNotNull {
                when (it) {
                    is TSGlobalMetaItem -> TSLookupElementFactory.build(it)
                    is TSGlobalMetaEnum -> TSLookupElementFactory.build(it, it.name)
                    else -> null
                }
            }
            .forEach { resultCaseInsensitive.addElement(it) }
    }

    private fun getBoostedItems(
        currentAttributeName: String,
        anotherAttributeMeta: TSGlobalMetaClassifier<out DomElement>,
        allItems: Collection<TSGlobalMetaClassifier<*>>
    ) = when (currentAttributeName) {
        Context.TYPE -> allItems
            .filter { meta ->
                when (meta) {
                    is TSGlobalMetaItem -> meta.allExtends.find { it == anotherAttributeMeta } != null
                    is TSGlobalMetaEnum -> anotherAttributeMeta.name == HybrisConstants.TS_TYPE_ENUMERATION_VALUE
                    else -> false
                }
            }

        Context.PARENT -> when (anotherAttributeMeta) {
            is TSGlobalMetaItem -> anotherAttributeMeta.allExtends
            is TSGlobalMetaEnum -> allItems
                .find { it.name == HybrisConstants.TS_TYPE_ENUMERATION_VALUE }
                ?.let { listOf(it) }
                ?: emptyList()

            else -> emptyList()
        }


        else -> null
    }

    private fun getAnotherType(
        currentAttributeName: String,
        tag: XmlTag,
    ) = when (currentAttributeName) {
        Context.TYPE -> tag.getAttributeValue(Context.PARENT)
        Context.PARENT -> tag.getAttributeValue(Context.TYPE)
        else -> null
    }

}