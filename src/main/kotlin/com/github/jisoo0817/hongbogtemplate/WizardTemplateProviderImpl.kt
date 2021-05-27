package com.github.jisoo0817.hongbogtemplate

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

class WizardTemplateProviderImpl  : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(activityTemplateKt,activityTemplateJava,daoTemplateKt,daoTemplateJava) 
}