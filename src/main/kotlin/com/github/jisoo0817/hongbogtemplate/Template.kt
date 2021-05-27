package com.github.jisoo0817.hongbogtemplate

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.Constraint.NONEMPTY
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val activityTemplateKt
    get() = template {
        revision = 1
        name = "HONGBOG Activity and Viewmodel in kotlin"
        description = "Activty & Layout 및 Viewmodel을 생성하는 템플릿"
        minApi = 16
        minBuildApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val entityName = stringParameter {
            name = "Activity Name"
            default = "Hongbog"
            help = "액티비티명"
            constraints = listOf(NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_hongbog"
            help = "레이아웃명"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(entityName.value.toLowerCase())}" }
        }

        val viewModelName = stringParameter {
            name = "ViewModel Name"
            default = "HongbogViewModel"
            help = "뷰모델명"
            constraints = listOf(NONEMPTY)
            suggest = { "${entityName.value}ViewModel"}
        }

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            TextFieldWidget(viewModelName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            hongbogSetupKt(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value,
                viewModelName.value
            )
        }
    }

val activityTemplateJava
    get() = template {
        revision = 1
        name = "HONGBOG Activity and Viewmodel in java"
        description = "Activty & Layout 및 Viewmodel을 생성하는 템플릿"
        minApi = 16
        minBuildApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val entityName = stringParameter {
            name = "Activity Name"
            default = "Hongbog"
            help = "액티비티명"
            constraints = listOf(NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_hongbog"
            help = "레이아웃명"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(entityName.value.toLowerCase())}" }
        }

        val viewModelName = stringParameter {
            name = "ViewModel Name"
            default = "HongbogViewModel"
            help = "뷰모델명"
            constraints = listOf(NONEMPTY)
            suggest = { "${entityName.value}ViewModel"}
        }

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            TextFieldWidget(viewModelName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            hongbogSetupJava(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value,
                viewModelName.value
            )
        }
    }



val daoTemplateKt
    get() = template {
        revision = 1
        name = "HONGBOG Dao in kotlin"
        description = "Dao를 생성해주는 템플릿"
        minApi = 16
        minBuildApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val DaoName = stringParameter {
            name = "Dao Name"
            default = "Hongbog"
            help = "다오명"
            constraints = listOf(NONEMPTY)
        }
        widgets(
            TextFieldWidget(DaoName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            hongbogDaoSetupKt(
                data as ModuleTemplateData,
                packageNameParam.value,
                DaoName.value,
            )
        }
    }



val daoTemplateJava
    get() = template {
        revision = 1
        name = "HONGBOG Dao in java"
        description = "Dao를 생성해주는 템플릿"
        minApi = 16
        minBuildApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val DaoName = stringParameter {
            name = "Dao Name"
            default = "Hongbog"
            help = "다오명"
            constraints = listOf(NONEMPTY)
        }
        widgets(
            TextFieldWidget(DaoName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            hongbogDaoSetupJava(
                data as ModuleTemplateData,
                packageNameParam.value,
                DaoName.value,
            )
        }
    }