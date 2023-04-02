package com.napptilus.willywonka.core.result


sealed class MyResult<out V, out E> {
    data class Ok<out V>(val value: V) : MyResult<V, Nothing>()
    data class Err<out E>(val error: E) : MyResult<Nothing, E>()
}

inline infix fun <V, E, F> MyResult<V, E>.mapError(transform: (E) -> F): MyResult<V, F> {
    return when (this) {
        is MyResult.Ok -> this
        is MyResult.Err -> MyResult.Err(transform(error))
    }
}

inline fun <V, E, U> MyResult<V, E>.mapBoth(success: (V) -> U, failure: (E) -> U): U {
    return when (this) {
        is MyResult.Ok -> success(value)
        is MyResult.Err -> failure(error)
    }
}

