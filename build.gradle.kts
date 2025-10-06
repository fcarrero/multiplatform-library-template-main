plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("org.jetbrains.compose") version "1.6.+" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.+" apply false // 👈 NUEVO
}
