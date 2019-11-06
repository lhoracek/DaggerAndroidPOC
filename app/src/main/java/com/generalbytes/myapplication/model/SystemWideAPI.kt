package com.generalbytes.myapplication.model


class SystemWideAPI constructor(val dependecy: ApiDependency) {
    public fun getData() = "I'm API (${dependecy.getData()})"
}