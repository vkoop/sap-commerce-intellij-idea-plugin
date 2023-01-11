/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
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

package com.intellij.idea.plugin.hybris.impex.completion.provider

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.idea.plugin.hybris.common.utils.HybrisI18NBundleUtils
import com.intellij.idea.plugin.hybris.common.utils.HybrisI18NBundleUtils.message
import com.intellij.idea.plugin.hybris.common.utils.HybrisIcons
import com.intellij.idea.plugin.hybris.impex.psi.ImpexAnyHeaderParameterName
import com.intellij.idea.plugin.hybris.impex.psi.ImpexFullHeaderParameter
import com.intellij.idea.plugin.hybris.system.type.meta.TSMetaModelAccess
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSGlobalMetaItem
import com.intellij.idea.plugin.hybris.system.type.meta.model.TSMetaRelation
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlTag
import com.intellij.util.ProcessingContext
import org.apache.commons.lang3.Validate

/**
 * @author Nosov Aleksandr <nosovae.dev@gmail.com>
 */
class ImpexHeaderItemTypeParameterNameCompletionProvider : CompletionProvider<CompletionParameters>() {

    public override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        Validate.notNull(parameters)
        Validate.notNull(result)

        val project = parameters.position.project
        val psiElementUnderCaret = parameters.position
        val typeName = findItemTypeReference(psiElementUnderCaret) ?: return

        val metaService = TSMetaModelAccess.getInstance(project)

        val metaItem = metaService.findMetaItemByName(typeName)
        if (metaItem == null) {
            addCompletionsForEnum(metaService, typeName, result)
        } else {
            addCompletionsForItem(metaItem, result)
        }
    }

    private fun addCompletionsForItem(
        metaItem: TSGlobalMetaItem,
        resultSet: CompletionResultSet
    ) {
        metaItem.allAttributes
            .map { prop ->
                val name = prop.name
                val builder = LookupElementBuilder.create(name)
                    .withIcon(HybrisIcons.ATTRIBUTE)
                    .withStrikeoutness(prop.isDeprecated)
                val typeText = getTypePresentableText(prop.type)
                if (StringUtil.isEmpty(typeText)) builder else builder.withTypeText(typeText, true)
            }
            .forEach { resultSet.addElement(it) }

        metaItem.allRelationEnds
            .map {
                LookupElementBuilder.create(it.qualifier)
                    .withStrikeoutness(it.isDeprecated)
                    .withIcon(
                        when (it.end) {
                            TSMetaRelation.RelationEnd.SOURCE -> HybrisIcons.RELATION_SOURCE
                            TSMetaRelation.RelationEnd.TARGET -> HybrisIcons.RELATION_TARGET
                        }
                    )
            }
            .forEach { resultSet.addElement(it) }
    }

    private fun addCompletionsForEnum(
        metaService: TSMetaModelAccess,
        typeName: String,
        resultSet: CompletionResultSet
    ) {
        metaService.findMetaEnumByName(typeName)
            ?.let {
                resultSet.addElement(
                    LookupElementBuilder.create("code")
                        .withTailText(if (it.isDynamic) " (" + message("hybris.ts.type.dynamic") + ")" else "", true)
                        .withIcon(HybrisIcons.ENUM)
                )
            }
    }

    private fun findItemTypeReference(element: PsiElement): String? {
        val parent = PsiTreeUtil.getParentOfType(element, ImpexFullHeaderParameter::class.java)
        val parameterName = PsiTreeUtil.findChildOfType(parent, ImpexAnyHeaderParameterName::class.java) ?: return null

        return parameterName.references
            .mapNotNull { it.resolve() }
            .firstNotNullOfOrNull { obtainTypeName(it) }
    }

    private fun obtainTypeName(reference: PsiElement): String? {
        val typeTag = PsiTreeUtil.findFirstParent(reference) { value -> value is XmlTag }
        return (typeTag as XmlTag).attributes.first { it.name == "type" }.value
    }

    companion object {

        val instance: CompletionProvider<CompletionParameters>
            get() = ApplicationManager.getApplication().getService(ImpexHeaderItemTypeParameterNameCompletionProvider::class.java)

        private fun getTypePresentableText(type: String?): String {
            if (type == null) {
                return ""
            }
            val index = type.lastIndexOf('.')
            return if (index >= 0) type.substring(index + 1) else type
        }
    }
}
