package com.napptilus.willywonka.network.di

import com.napptilus.willywonka.core.BuildConfig
import com.napptilus.willywonka.network.api.Api
import com.napptilus.willywonka.network.connectivity.NetworkConnectivityInterceptor
import com.napptilus.willywonka.network.di.utils.addJsonConverterFactory
import com.napptilus.willywonka.network.di.utils.addTimeout
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiProvider {

    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addJsonConverterFactory()
        .build()

    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        networkConnectivityInterceptor: NetworkConnectivityInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkConnectivityInterceptor)
            .addTimeout()
            .build()

    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}
