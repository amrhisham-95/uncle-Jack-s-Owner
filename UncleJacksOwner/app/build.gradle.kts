plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

//safeArguments For (Navigation)
    id("androidx.navigation.safeargs.kotlin")
    //For Parcelizing
    id("kotlin-parcelize")

    id("com.google.gms.google-services")

    //dagger hilt
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")


    //for dagger Hilt
    id ("dagger.hilt.android.plugin")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

    id ("org.jetbrains.kotlin.plugin.serialization")
    id ("kotlinx-serialization")

}

android {
    namespace = "com.amrhishammahmoud.uncleJacksOwner"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.amrhishammahmoud.uncleJacksOwner"
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

    allprojects {
        configurations.all {
            resolutionStrategy.dependencySubstitution {
                substitute(module("org.hamcrest:hamcrest-core:1.1")).using(module("junit:junit:4.10"))
            }
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)


        implementation(libs.testng)
        //firebase
        implementation(libs.firebase.auth)

        implementation(libs.firebase.core)

        implementation (libs.firebase.database)

        //For Navigation
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)


        //for Maps
        implementation(libs.play.services.maps)
        //fused location provider maps
        implementation(libs.play.services.location)


        //for firebase (google)
        implementation(libs.firebase.ui.auth)

        //For Navigation
        implementation(libs.androidx.navigation.fragment.ktx.v277)
        implementation(libs.androidx.navigation.ui.ktx.v277)


        //for firebase
        implementation(libs.firebase.ui.auth)
        implementation(libs.firebase.auth.ktx)


        // Import the BoM for the Firebase platform
        implementation(platform(libs.firebase.bom))
        // Add the dependency for the Firebase Authentication library
        implementation(libs.google.firebase.auth.ktx)


        implementation(platform(libs.firebase.bom.v3351))


        //activity androidX - viewModel
        implementation(libs.androidx.activity.ktx)
        //fragment androidX - viewModel
        implementation(libs.androidx.fragment.ktx)

        //retrofit
        implementation(libs.retrofit)
        //Json converter
        implementation(libs.converter.gson)
        //Json To Kotlin Library
        implementation(libs.library)

        //RXJava
        implementation(libs.rxjava)
        //RX Android
        implementation(libs.rxandroid)
        //Adapter for RXJava3
        implementation(libs.adapter.rxjava3)

        //liveData
        implementation(libs.androidx.lifecycle.livedata.ktx)

        // Room components
        implementation(libs.androidx.room.runtime)
        //noinspection KaptUsageInsteadOfKsp
        kapt(libs.room.compiler)
        implementation(libs.androidx.room.ktx)
        androidTestImplementation(libs.androidx.room.testing)

        // Lifecycle components
        implementation(libs.androidx.lifecycle.extensions)
        implementation(libs.androidx.lifecycle.common.java8)
        implementation(libs.androidx.lifecycle.viewmodel.ktx.v287)

        // Download and parse data
        implementation(libs.moshi)
        implementation(libs.moshi.kotlin)
        implementation(libs.retrofit)
        implementation(libs.converter.moshi)
        implementation(libs.converter.scalars)

        // Image downloader
        implementation(libs.picasso)
        //for glide
        implementation(libs.github.glide)

        // Kotlin coroutines
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.retrofit2.kotlin.coroutines.adapter)


        // Work manager
        implementation(libs.androidx.work.runtime.ktx)

        //for pagination
        implementation(libs.androidx.paging.runtime.ktx)
        implementation(libs.androidx.paging.common.ktx)


        //for coil
        implementation(libs.coil)

        implementation(libs.support.multidex)

        //for auth google
        // Import the Firebase BoM
        implementation(platform(libs.firebase.bom.v3351))



        implementation(libs.firebase.analytics)


        // When using the BoM, don't specify versions in Firebase dependencies
        implementation(libs.firebase.analytics.ktx)





        implementation(platform(libs.kotlin.bom))

        implementation(libs.library)


        //curvedBottomNavigation
        implementation(libs.qamarelsafadi.curvedbottomnavigation)

        //for dagger hilt
        implementation(libs.github.glide)
        implementation(libs.androidx.activity.ktx.v140)
        kapt(libs.kotlinx.metadata.jvm)
        implementation(libs.androidx.core.ktx.v1130)
        implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
        implementation(libs.androidx.lifecycle.livedata.ktx.v287)
        implementation(libs.hilt.android)
        kapt(libs.hilt.android.compiler)
        kapt(libs.androidx.hilt.compiler)
        implementation(libs.androidx.hilt.navigation.fragment)


        implementation (libs.support.multidex)

        //for auth google
        // Import the Firebase BoM
        implementation(platform(libs.firebase.bom.v3240))

        // TODO: Add the dependencies for Firebase products you want to use
        // When using the BoM, don't specify versions in Firebase dependencies
        implementation(libs.google.firebase.analytics.ktx)


        //curvedBottomNavigation
        implementation (libs.qamarelsafadi.curvedbottomnavigation)


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
     //   implementation ("com.google.android.gms:play-services-ads:22.3.0")



    }
}
dependencies {
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore.ktx)
}
