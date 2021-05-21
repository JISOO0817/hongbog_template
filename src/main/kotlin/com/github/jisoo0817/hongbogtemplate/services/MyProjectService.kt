package com.github.jisoo0817.hongbogtemplate.services

import com.github.jisoo0817.hongbogtemplate.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
