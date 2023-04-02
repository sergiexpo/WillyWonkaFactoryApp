package com.napptilus.willywonka.core.usecase

fun interface UseCaseSuspend<Params, Return> {
    suspend operator fun invoke(params: Params): Return
}
