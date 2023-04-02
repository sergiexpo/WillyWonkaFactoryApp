package com.napptilus.willywonka.network.di

import com.napptilus.willywonka.network.connectivity.NetworkConnectivityInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val API_NAME = "network_api"

val networkModule = module {
    single {
        ApiProvider.provideApi(get(named(API_NAME)))
    }
    single(named(API_NAME)) {
        ApiProvider.provideRetrofit(get(named(API_NAME)))
    }
    single(named(API_NAME)) {
        ApiProvider.provideOkHttpClient(
            networkConnectivityInterceptor = get(),
            loggingInterceptor = get(),
        )
    }
    single { ApiProvider.provideLoggingInterceptor() }
    singleOf(::NetworkConnectivityInterceptor)
}