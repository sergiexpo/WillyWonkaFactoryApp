package com.napptilus.willywonka.network.di.utils

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

private const val REQUEST_TIME_OUT = 30L

internal fun OkHttpClient.Builder.addTimeout() =
    callTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)