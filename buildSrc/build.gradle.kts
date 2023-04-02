import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    mavenCentral()
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.16.0-RC3")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.1.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.1.1")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.39.0")
    implementation(gradleApi())
    implementation(localGroovy())
}