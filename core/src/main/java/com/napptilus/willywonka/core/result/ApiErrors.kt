package com.napptilus.willywonka.core.result

import android.accounts.NetworkErrorException
import java.util.concurrent.CancellationException

enum class GenericApiError {
    NoInternet,
    Network,
    Unknown
}

object ApiErrorHandling {
    suspend fun <T> run(block: suspend () -> T): MyResult<T, GenericApiError> =
        try {
            MyResult.Ok(block())
        } catch (e: Throwable) {
            handleGenericExceptions(e)
        }

    private fun handleGenericExceptions(e: Throwable) = when (e) {
        is CancellationException -> throw e
        is NoConnectivityException -> MyResult.Err(GenericApiError.NoInternet)
        is NetworkErrorException -> MyResult.Err(GenericApiError.Network)
        else -> MyResult.Err(GenericApiError.Unknown)
    }
}
