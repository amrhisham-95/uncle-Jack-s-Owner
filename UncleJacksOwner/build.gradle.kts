buildscript {
    dependencies {
        classpath(libs.google.services)
        classpath (libs.google.services)
        classpath (libs.kotlin.serialization)

    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false


    //safeArguments For (Navigation)
    id("androidx.navigation.safeargs") version "2.8.3" apply false

    //for Maps
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false

    // Add the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.2" apply false

    id("com.android.library") version "7.4.2" apply false

    //for dagger hilt
    id("com.google.dagger.hilt.android") version "2.48.1" apply false


}