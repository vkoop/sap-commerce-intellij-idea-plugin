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

package com.intellij.idea.plugin.hybris.tools.ccv2.dto

import com.intellij.idea.plugin.hybris.ccv1.model.MediaStorageDTO
import com.intellij.idea.plugin.hybris.ccv2.model.EnvironmentDetailDTO
import com.intellij.idea.plugin.hybris.common.HybrisConstants

data class CCv2MediaStorageDto(
    val code: String,
    val name: String,
    val accountName: String,
    val publicUrl: String,
    var accountKey: String? = null,
    val link: String
) {
    companion object {
        fun map(environment: EnvironmentDetailDTO, dto: MediaStorageDTO) = CCv2MediaStorageDto(
            code = dto.code,
            name = dto.name,
            accountName = dto.accountName,
            publicUrl = dto.publicUrl,
            link = "https://${HybrisConstants.CCV2_DOMAIN}/subscription/${environment.subscriptionCode}/applications/commerce-cloud/environments/${environment.code}/cloud-storage/${dto.code}"
        )
    }
}
