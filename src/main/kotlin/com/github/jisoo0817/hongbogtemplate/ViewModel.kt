package com.github.jisoo0817.hongbogtemplate


// <-----------------------------------kotlin---------------------------------------

fun hongbogViewModelKt(
    packageName: String,
    viewModelName: String) ="""package ${packageName}
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import android.app.Application
    
class ${viewModelName}ViewModel(application: Application): AndroidViewModel(application) {
    
    private val app: Application = application
    
}
"""


// <-----------------------------------Java---------------------------------------

fun hongbogViewModelJava(
    packageName: String,
    viewModelName: String) ="""package ${packageName};

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import android.app.Application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ${viewModelName}ViewModel extends AndroidViewModel {

    public ${viewModelName}ViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
"""