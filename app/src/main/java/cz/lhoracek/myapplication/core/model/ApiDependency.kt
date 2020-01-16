package cz.lhoracek.myapplication.core.model

import javax.inject.Inject


class ApiDependency @Inject constructor() {
    public fun getData() = "I'm dependecy"
}