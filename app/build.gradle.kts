plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
}

commonAndroidConfig()

android {
    defaultConfig {
        applicationId = AndroidSdk.applicationId
    }
    setupCompose()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    modules(listOf(Modules.Core, Modules.Libs.CommonsUi))

    implementations(DependencyGroups.diUi)
    implementations(DependencyGroups.network)
    implementation(Dependencies.Libraries.coil)
    implementation(Dependencies.Libraries.coilSvg)
    implementation(Dependencies.Libraries.coilCompose)
    implementation(Dependencies.Database.datastorePreferences)
    implementation(Dependencies.SupportLibs.splashScreen)

    implementation(platform(Dependencies.Compose.bom))
    implementations(DependencyGroups.compose)
    debugImplementation(Dependencies.Compose.uiTooling)

    testImplementation(Dependencies.Testing.mockk)

    androidTestImplementation(Dependencies.Testing.composeAndroidTest)

}
