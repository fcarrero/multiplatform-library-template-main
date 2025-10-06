plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.compose")                 // runtime/libs de Compose MPP
    id("org.jetbrains.kotlin.plugin.compose")   // 👈 Compose Compiler (Kotlin 2.0+)
    alias(libs.plugins.vanniktech.mavenPublish)
    id 'maven-publish'
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions { jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11) }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    // opcional: jvm(), linuxX64(), etc.

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.material3)
                implementation("androidx.activity:activity-compose:1.9.0")
            }
        }
    }
}

android {
    namespace = "org.jetbrains.kotlinx.multiplatform.library.template"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }
    buildFeatures { compose = true }
    // IMPORTANTE: NO uses composeOptions { kotlinCompilerExtensionVersion = ... } con Kotlin 2.0+
}
group = "com.github.fcarrero"
version = "1.0.0"

