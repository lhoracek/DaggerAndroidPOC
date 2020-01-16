package cz.lhoracek.myapplication.core.interactor

import kotlinx.coroutines.*


abstract class BaseUseCase<out Type, in Params> where Type : Any {

    protected abstract suspend fun run(params: Params): Either<Failure, Type>

    open operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        jobDispatcher: CoroutineDispatcher = Dispatchers.IO,
        resultDispatcher: CoroutineDispatcher = Dispatchers.Main,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        val backgroundJob = scope.async(jobDispatcher) {
            run(params)
        }
        scope.launch(resultDispatcher) { onResult(backgroundJob.await()) }
    }

    open class None
}