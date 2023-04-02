package com.napptilus.willywonka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.napptilus.willywonka.commonsui.compose.theme.WillyWonkaTheme
import com.napptilus.willywonka.presentation.AppLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WillyWonkaTheme() {
                AppLayout()
            }
        }
    }
}