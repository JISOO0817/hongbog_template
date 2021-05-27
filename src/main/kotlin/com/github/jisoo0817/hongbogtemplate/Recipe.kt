package com.github.jisoo0817.hongbogtemplate

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.jisoo0817.hongbogtemplate.listeners.MyProjectManagerListener.Companion.projectInstance
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.KotlinLanguage

fun RecipeExecutor.hongbogSetupKt(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String,
    viewModelName: String
) {
    val (projectData) = moduleData
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.first { it.path.contains("src") }
    val virtRes = virtualFiles.first { it.path.contains("res") }
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc)!!
    val directoryRes = PsiManager.getInstance(project).findDirectory(virtRes)!!

    //activity
    hongbogActivityKt(packageName, entityName, layoutName, projectData)
        .save(directorySrc, packageName, "${entityName}Activity.kt")

    //xml
    hongbogLayoutKt(packageName, entityName)
        .save(directoryRes, "layout", "${layoutName}.xml")


    //viewmodel
    hongbogViewModelKt(packageName, entityName)
        .save(directorySrc, packageName, "${entityName}ViewModel.kt")

}

fun RecipeExecutor.hongbogSetupJava(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String,
    viewModelName: String
) {
    val (projectData) = moduleData
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.first { it.path.contains("src") }
    val virtRes = virtualFiles.first { it.path.contains("res") }
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc)!!
    val directoryRes = PsiManager.getInstance(project).findDirectory(virtRes)!!

    //activity
    hongbogActivityJava(packageName, entityName, layoutName, projectData)
        .save(directorySrc, packageName, "${entityName}Activity.java")

    //xml
    hongbogLayoutJava(packageName, entityName)
        .save(directoryRes, "layout", "${layoutName}.xml")


    //viewmodel
    hongbogViewModelJava(packageName, entityName)
        .save(directorySrc, packageName, "${entityName}ViewModel.java")

}

fun RecipeExecutor.hongbogDaoSetupKt(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String
) {
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.first { it.path.contains("src") }
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc)!!

    //dao
    hongbogDaoKt(packageName,entityName)
        .save(directorySrc,packageName,"${entityName}Dao.kt")
}

fun RecipeExecutor.hongbogDaoSetupJava(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String
) {
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.first { it.path.contains("src") }
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc)!!


    hongbogDaoJava(packageName,entityName)
        .save(directorySrc,packageName,"${entityName}Dao.java")
}

fun String.save(srcDir: PsiDirectory, subDirPath: String, fileName: String) {
    try {
        val destDir = subDirPath.split(".").toDir(srcDir)
        val psiFile = PsiFileFactory
            .getInstance(srcDir.project)
            .createFileFromText(fileName, KotlinLanguage.INSTANCE, this)
        destDir.add(psiFile)
    }catch (exc: Exception) {
        exc.printStackTrace()
    }
}

fun List<String>.toDir(srcDir: PsiDirectory): PsiDirectory {
    var result = srcDir
    forEach {
        result = result.findSubdirectory(it) ?: result.createSubdirectory(it)
    }
    return result
}