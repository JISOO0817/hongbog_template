package com.github.jisoo0817.hongbogtemplate

// <-----------------------------------kotlin---------------------------------------

fun hongbogDaoKt(
    packageName: String,
    entityName: String) ="""package ${packageName}

import androidx.room.Dao

@Dao
abstract class ${entityName}Dao{
   
}   
"""



// <-----------------------------------java---------------------------------------


fun hongbogDaoJava(
    packageName: String,
    entityName: String) ="""package ${packageName};

import androidx.room.Dao;

@Dao
abstract class ${entityName}Dao{

}
"""
