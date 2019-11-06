package com.generalbytes.myapplication.model

import javax.inject.Inject


class ApiDependency @Inject constructor() {
    public fun getData() = "I'm dependecy"
}