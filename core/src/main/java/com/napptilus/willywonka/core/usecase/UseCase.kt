package com.napptilus.willywonka.core.usecase

fun interface UseCase<Params, Return> {
    operator fun invoke(params: Params): Return
}
