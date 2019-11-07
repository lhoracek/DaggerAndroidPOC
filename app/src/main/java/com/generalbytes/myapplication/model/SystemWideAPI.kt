package com.generalbytes.myapplication.model


class SystemWideAPI constructor(val dependecy: ApiDependency) : ApiInterface {
    override fun getData() = "I'm API (${dependecy.getData()})"


}

interface ApiInterface {
    fun getData(): String
}