package com.napptilus.willywonka

import android.app.Application
import com.napptilus.willywonka.commonsui.di.commonsUiModule
import com.napptilus.willywonka.core.di.coreModule
import com.napptilus.willywonka.feature.detail.di.detailModule
import com.napptilus.willywonka.feature.home.di.homeModule
import com.napptilus.willywonka.network.di.networkModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi() {
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    coreModule,
                    commonsUiModule,
                    networkModule,
                    homeModule,
                    detailModule,
                )
            )
        }
    }
}