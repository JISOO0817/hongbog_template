package com.github.jisoo0817.hongbogtemplate

import com.android.tools.idea.wizard.template.ProjectTemplateData


// <-----------------------------------kotlin---------------------------------------


fun hongbogActivityKt(
    packageName: String,
    entityName: String,
    layoutName: String,
    projectData: ProjectTemplateData
) ="""package ${packageName}
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ${projectData.applicationPackage}.databinding.Activity${entityName}Binding

class ${entityName}Activity : BaseActivity() {

    private val viewModel: ${entityName}ViewModel by viewModels()
    private lateinit var binding: Activity${entityName}Binding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setUpBinding()
        setUpView()
        setUpObserver()
    }
    
    private fun setUpBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.${layoutName})
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
    }
    
    private fun setUpView() {
         
    }
    
    private fun setUpObserver() {
        
    }  
    
}"""

fun hongbogLayoutKt(
    packageName: String,
    entityName: String) = """<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${entityName}ViewModel" />

    </data>
    
    <androidx.constraintlayout.widget.ConstraintLayout 
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName}.${entityName}Activity">
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""


//<-----------------------------------java---------------------------------------


fun hongbogActivityJava(
    packageName: String,
    entityName: String,
    layoutName: String,
    projectData: ProjectTemplateData) ="""package ${packageName};
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import ${projectData.applicationPackage}.BaseActivity;
import ${projectData.applicationPackage}.R;
import ${projectData.applicationPackage}.databinding.Activity${entityName}Binding;

public class ${entityName}Activity extends BaseActivity {

    private ${entityName}ViewModel mViewModel;
    private Activity${entityName}Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpBinding();
        setUpView();
        setUpObserver();
    }

    private void setUpBinding() {
        binding = DataBindingUtil.setContentView(this,R.layout.${layoutName});
        mViewModel = obtainViewModel();
        binding.setLifecycleOwner(this);
        binding.setViewModel(mViewModel);
    }

    private void setUpView() {

    }

    private void setUpObserver() {

    }

    @NonNull
    private ${entityName}ViewModel obtainViewModel() {
        ViewModelProvider.AndroidViewModelFactory viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        return new ViewModelProvider(this,viewModelFactory).get(${entityName}ViewModel.class);
    }

}"""

fun hongbogLayoutJava(
    packageName: String,
    entityName: String) = """<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
    
        <variable
            name="viewModel"
            type="${packageName}.${entityName}ViewModel" />

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName}.${entityName}Activity">
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""

