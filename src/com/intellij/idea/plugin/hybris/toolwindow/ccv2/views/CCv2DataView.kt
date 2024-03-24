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

package com.intellij.idea.plugin.hybris.toolwindow.ccv2.views

import com.intellij.idea.plugin.hybris.toolwindow.ccv2.CCv2Tab
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.Align
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.panel

abstract class CCv2DataView {

    abstract val tab: CCv2Tab

    fun fetchingInProgress(): DialogPanel = panel {
        row {
            label("Fetching ${tab.title} data, Please wait...")
                .align(Align.FILL)
        }
    }

    fun noDataPanel(): DialogPanel = panel {
        noData()
    }

    protected fun Panel.noData() {
        row {
            label("No ${CCv2EnvironmentsDataView.tab.title} data available...")
                .align(Align.FILL)
        }
    }
}