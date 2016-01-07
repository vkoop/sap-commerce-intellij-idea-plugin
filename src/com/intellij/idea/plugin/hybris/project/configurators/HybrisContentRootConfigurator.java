/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2015 Alexander Bartash <AlexanderBartash@gmail.com>
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

package com.intellij.idea.plugin.hybris.project.configurators;

import com.intellij.idea.plugin.hybris.project.settings.HybrisModuleDescriptor;
import com.intellij.idea.plugin.hybris.utils.HybrisConstants;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VfsUtil;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.java.JavaResourceRootType;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;

import java.io.File;

import static com.intellij.idea.plugin.hybris.utils.HybrisConstants.*;

/**
 * Created 2:07 AM 15 June 2015.
 *
 * @author Alexander Bartash <AlexanderBartash@gmail.com>
 */
public class HybrisContentRootConfigurator implements ContentRootConfigurator {

    @Override
    public void configure(@NotNull final ModifiableRootModel modifiableRootModel,
                          @NotNull final HybrisModuleDescriptor moduleDescriptor) {
        Validate.notNull(modifiableRootModel);
        Validate.notNull(moduleDescriptor);

        final ContentEntry contentEntry = modifiableRootModel.addContentEntry(VfsUtil.pathToUrl(
            moduleDescriptor.getRootDirectory().getAbsolutePath()
        ));


        this.configureCommonRoots(moduleDescriptor, contentEntry);
        this.configureHmcRoots(moduleDescriptor, contentEntry, moduleDescriptor.getRootDirectory());
        this.configureWebRoots(moduleDescriptor, contentEntry, moduleDescriptor.getRootDirectory());
        this.configureCommonWebRoots(moduleDescriptor, contentEntry);
        this.configureAcceleratorAddonRoots(moduleDescriptor, contentEntry);
        this.configureBackOfficeRoots(moduleDescriptor, contentEntry);
        this.configurePlatformRoots(moduleDescriptor, contentEntry);
    }

    protected void configureCommonRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                        @NotNull final ContentEntry contentEntry) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);

        if (moduleDescriptor.isInCustomDir() || !moduleDescriptor.getRootProjectDescriptor().isImportOotbModulesInReadOnlyMode()) {
            final File srcDirectory = new File(moduleDescriptor.getRootDirectory(), SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(srcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE
            );

            final File genSrcDirectory = new File(moduleDescriptor.getRootDirectory(), GEN_SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(genSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE,
                JpsJavaExtensionService.getInstance().createSourceRootProperties("", true)
            );

            final File testSrcDirectory = new File(moduleDescriptor.getRootDirectory(), TEST_SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(testSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.TEST_SOURCE
            );

            final File resourcesDirectory = new File(moduleDescriptor.getRootDirectory(), RESOURCES_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(resourcesDirectory.getAbsolutePath()),
                JavaResourceRootType.RESOURCE
            );
        }

        final File externalToolBuildersDirectory = new File(
            moduleDescriptor.getRootDirectory(), EXTERNAL_TOOL_BUILDERS_DIRECTORY
        );

        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(externalToolBuildersDirectory.getAbsolutePath())
        );

        final File settingsDirectory = new File(moduleDescriptor.getRootDirectory(), SETTINGS_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(settingsDirectory.getAbsolutePath())
        );

        final File classesDirectory = new File(moduleDescriptor.getRootDirectory(), CLASSES_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(classesDirectory.getAbsolutePath())
        );

        final File eclipseBinDirectory = new File(moduleDescriptor.getRootDirectory(), ECLIPSE_BIN_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(eclipseBinDirectory.getAbsolutePath())
        );
    }

    protected void configureHmcRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                     @NotNull final ContentEntry contentEntry,
                                     @NotNull final File parentDirectory) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);
        Validate.notNull(parentDirectory);


        final File hmcModuleDirectory = new File(parentDirectory, HMC_MODULE_DIRECTORY);

        if (moduleDescriptor.isInCustomDir() || !moduleDescriptor.getRootProjectDescriptor().isImportOotbModulesInReadOnlyMode()) {
            final File hmcSrcDirectory = new File(hmcModuleDirectory, SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(hmcSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE
            );

            final File hmcResourcesDirectory = new File(hmcModuleDirectory, RESOURCES_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(hmcResourcesDirectory.getAbsolutePath()),
                JavaResourceRootType.RESOURCE
            );
        }

        final File hmcClassesDirectory = new File(hmcModuleDirectory, CLASSES_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(hmcClassesDirectory.getAbsolutePath())
        );
    }

    protected void configureWebRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                     @NotNull final ContentEntry contentEntry,
                                     @NotNull final File parentDirectory) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);
        Validate.notNull(parentDirectory);

        final File webModuleDirectory = new File(parentDirectory, WEB_MODULE_DIRECTORY);
        this.configureWebModuleRoots(moduleDescriptor, contentEntry, webModuleDirectory);
    }

    protected void configureCommonWebRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                           @NotNull final ContentEntry contentEntry) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);

        final File commonWebModuleDirectory = new File(
            moduleDescriptor.getRootDirectory(), COMMON_WEB_MODULE_DIRECTORY
        );

        this.configureWebModuleRoots(moduleDescriptor, contentEntry, commonWebModuleDirectory);
    }

    protected void configureAcceleratorAddonRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                                  @NotNull final ContentEntry contentEntry) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);

        final File commonWebModuleDirectory = new File(
            moduleDescriptor.getRootDirectory(), ACCELERATOR_ADDON_DIRECTORY
        );
        this.configureWebRoots(moduleDescriptor, contentEntry, commonWebModuleDirectory);
        this.configureHmcRoots(moduleDescriptor, contentEntry, commonWebModuleDirectory);
    }

    protected void configureBackOfficeRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                            @NotNull final ContentEntry contentEntry) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);

        final File backOfficeModuleDirectory = new File(
            moduleDescriptor.getRootDirectory(), BACK_OFFICE_MODULE_DIRECTORY
        );

        if (moduleDescriptor.isInCustomDir() || !moduleDescriptor.getRootProjectDescriptor().isImportOotbModulesInReadOnlyMode()) {
            final File backOfficeSrcDirectory = new File(backOfficeModuleDirectory, SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(backOfficeSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE
            );

            final File backOfficeTestSrcDirectory = new File(backOfficeModuleDirectory, TEST_SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(backOfficeTestSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.TEST_SOURCE
            );

            final File hmcResourcesDirectory = new File(backOfficeModuleDirectory, RESOURCES_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(hmcResourcesDirectory.getAbsolutePath()),
                JavaResourceRootType.RESOURCE
            );
        }

        final File hmcClassesDirectory = new File(backOfficeModuleDirectory, CLASSES_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(hmcClassesDirectory.getAbsolutePath())
        );
    }

    protected void configurePlatformRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                          @NotNull final ContentEntry contentEntry) {
        Validate.notNull(moduleDescriptor);
        Validate.notNull(contentEntry);

        if (!HybrisConstants.PLATFORM_EXTENSION_NAME.equalsIgnoreCase(moduleDescriptor.getName())) {
            return;
        }

        final File platformBootstrapDirectory = new File(
            moduleDescriptor.getRootDirectory(), PLATFORM_BOOTSTRAP_DIRECTORY
        );

        if (!moduleDescriptor.getRootProjectDescriptor().isImportOotbModulesInReadOnlyMode()) {

            final File platformBootstrapResourcesDirectory = new File(platformBootstrapDirectory, RESOURCES_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(platformBootstrapResourcesDirectory.getAbsolutePath()),
                JavaResourceRootType.RESOURCE
            );
        }

        final File platformBootstrapModelClassesDirectory = new File(
            platformBootstrapDirectory, PLATFORM_MODEL_CLASSES_DIRECTORY
        );

        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(platformBootstrapModelClassesDirectory.getAbsolutePath())
        );

        final File platformTomcatDirectory = new File(
            moduleDescriptor.getRootDirectory(), PLATFORM_TOMCAT_DIRECTORY
        );
        final File platformTomcatWorkDirectory = new File(platformTomcatDirectory, PLATFORM_TOMCAT_WORK_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(platformTomcatWorkDirectory.getAbsolutePath())
        );
    }

    private void configureWebModuleRoots(@NotNull final HybrisModuleDescriptor moduleDescriptor,
                                         final @NotNull ContentEntry contentEntry,
                                         final File webModuleDirectory) {
        Validate.notNull(moduleDescriptor);

        if (moduleDescriptor.isInCustomDir() || !moduleDescriptor.getRootProjectDescriptor().isImportOotbModulesInReadOnlyMode()) {
            final File webSrcDirectory = new File(webModuleDirectory, SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(webSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE
            );

            final File webGenSrcDirectory = new File(webModuleDirectory, GEN_SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(webGenSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.SOURCE,
                JpsJavaExtensionService.getInstance().createSourceRootProperties("", true)
            );

            final File webTestSrcDirectory = new File(webModuleDirectory, TEST_SRC_DIRECTORY);
            contentEntry.addSourceFolder(
                VfsUtil.pathToUrl(webTestSrcDirectory.getAbsolutePath()),
                JavaSourceRootType.TEST_SOURCE
            );
        }

        final File webAddonSrcDirectory = new File(webModuleDirectory, ADDON_SRC_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(webAddonSrcDirectory.getAbsolutePath())
        );

        final File webTestClassesDirectory = new File(webModuleDirectory, TEST_CLASSES_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(webTestClassesDirectory.getAbsolutePath())
        );

        final File commonWebSrcDirectory = new File(webModuleDirectory, COMMON_WEB_SRC_DIRECTORY);
        contentEntry.addExcludeFolder(
            VfsUtil.pathToUrl(commonWebSrcDirectory.getAbsolutePath())
        );
    }
}
