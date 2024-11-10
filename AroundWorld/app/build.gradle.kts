plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id ("kotlin-kapt")
    //safeArguments For (Navigation)
    id ("androidx.navigation.safeargs.kotlin")
    //For Parcelizing
    id ("kotlin-parcelize")

    //for dagger Hilt
    id ("dagger.hilt.android.plugin")
    id ("com.google.gms.google-services")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

    id ("org.jetbrains.kotlin.plugin.serialization")
    id ("kotlin-android")
    id ("kotlinx-serialization")
}

android {
    namespace = "com.amrhishammahmoud.aroundworld"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.amrhishammahmoud.aroundworld"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true

    }
}

dependencies {


    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.material)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.firebase.auth)
    implementation (libs.firebase.database)
    implementation (libs.firebase.firestore.ktx)
    implementation(libs.androidx.activity)
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.espresso.core)

    //For Navigation
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    //for Maps
    implementation (libs.play.services.maps)
    //fused location provider maps
    implementation (libs.play.services.location)


    //for firebase (google)
    implementation (libs.firebase.ui.auth)

    //For Navigation
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)


    //for firebase
    implementation (libs.firebase.ui.auth)
    implementation (libs.google.firebase.auth.ktx)


    // Import the BoM for the Firebase platform
    implementation (platform ("com.google.firebase:firebase-bom:31.2.2"))
    // Add the dependency for the Firebase Authentication library
    implementation (libs.firebase.auth.ktx)


    implementation (platform(libs.firebase.bom))

    //activity androidX - viewModel
    implementation (libs.androidx.activity.ktx)
    //fragment androidX - viewModel
    implementation (libs.androidx.fragment.ktx)

    //retrofit
    implementation (libs.retrofit)
    //Json converter
    implementation (libs.converter.gson)
    //Json To Kotlin Library
    implementation (libs.library)

    //RXJava
    implementation (libs.rxjava)
    //RX Android
    implementation (libs.rxandroid)
    //Adapter for RXJava3
    implementation (libs.retrofit2.adapter.rxjava3)

    //liveData
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Room components
    implementation (libs.androidx.room.runtime)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.room.compiler)
    implementation (libs.androidx.room.ktx)
    androidTestImplementation (libs.androidx.room.testing)

    // Lifecycle components
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.lifecycle.common.java8)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // Download and parse data
    implementation (libs.moshi)
    implementation (libs.moshi.kotlin)
    implementation (libs.retrofit)
    implementation (libs.converter.moshi)
    implementation (libs.converter.scalars)

    // Image downloader
    implementation (libs.picasso)

    // Kotlin coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.retrofit2.kotlin.coroutines.adapter)


    // Work manager
    implementation (libs.androidx.work.runtime.ktx)

    //for pagination
    implementation (libs.androidx.paging.runtime.ktx)
    implementation (libs.paging.common.ktx)

    //for glide
    implementation (libs.glide)

    //for coil
    implementation (libs.coil)

    //for dagger hilt
    //for dagger hilt
    implementation(libs.glide)
    implementation(libs.androidx.activity.ktx)
    kapt(libs.kotlinx.metadata.jvm)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.hilt.navigation.fragment)


    implementation (libs.multidex)

    //for auth google
    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))

    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(libs.firebase.analytics.ktx)


    //curvedBottomNavigation
    implementation (libs.curvedbottomnavigation)


    //ktor client
    implementation (libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation (libs.ktor.client.json)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.logging.jvm)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.cio)


    implementation(libs.ktor.client.content.negotiation)


    //google ads
    // implementation ("com.google.android.gms:play-services-ads:23.0.0")
}