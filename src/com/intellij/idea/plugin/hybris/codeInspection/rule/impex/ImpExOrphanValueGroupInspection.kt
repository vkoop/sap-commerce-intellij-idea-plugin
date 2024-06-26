/*
 * This file is part of "SAP Commerce Developers Toolset" plugin for Intellij IDEA.
 * Copyright (C) 2019-2023 EPAM Systems <hybrisideaplugin@epam.com> and contributors
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

package com.intellij.idea.plugin.hybris.codeInspection.rule.impex

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.idea.plugin.hybris.codeInspection.fix.impex.ImpExDeleteValueGroupFix
import com.intellij.idea.plugin.hybris.common.utils.HybrisI18NBundleUtils.message
import com.intellij.idea.plugin.hybris.impex.psi.ImpexValueLine
import com.intellij.idea.plugin.hybris.impex.psi.ImpexVisitor
import com.intellij.psi.PsiElementVisitor
import kotlin.math.absoluteValue

class ImpExOrphanValueGroupInspection : LocalInspectionTool() {

    override fun getDefaultLevel(): HighlightDisplayLevel = HighlightDisplayLevel.ERROR
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor = Visitor(holder)

    class Visitor(private val holder: ProblemsHolder) : ImpexVisitor() {
        override fun visitValueLine(valueLine: ImpexValueLine) {
            val headerLine = valueLine.headerLine
                ?: return
            val valueGroups = valueLine.valueGroupList
            val headerParameters = headerLine.fullHeaderParameterList

            val missingValueGroups = headerParameters.size - valueGroups.size
            if (missingValueGroups < 0) {
                valueGroups.takeLast(missingValueGroups.absoluteValue)
                    .forEach { valueGroup ->
                        // value groups can be long, no need to show full content
                        val previewText = valueGroup.text.trim()
                            .let {
                                return@let if (it.length > 50) it.substring(0, 50) + "..."
                                else it
                            }

                        holder.registerProblem(
                            valueGroup,
                            message("hybris.inspections.impex.ImpExOrphanValueGroupInspection.key", previewText),
                            ProblemHighlightType.WARNING,
                            ImpExDeleteValueGroupFix(valueGroup, previewText)
                        )
                    }
            }
        }
    }
}