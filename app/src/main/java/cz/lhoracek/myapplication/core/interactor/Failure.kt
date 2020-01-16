package cz.lhoracek.myapplication.core.interactor


sealed class Failure {

    object NetworkConnection : Failure()
    object ServerError : Failure()

    open class ExceptionFailure(exception: Exception) : Failure()

    open class FeatureFailure(featureMessage: String) : Failure()

}