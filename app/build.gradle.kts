import deps.Dependencies
import deps.Versions

plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    defaultConfig {
        applicationId = "com.shiv.demo"
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = Dependencies.Test.junitRunner
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/*.version")
        exclude("META-INF/proguard/*.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        dataBinding = true
    }
}
dependencies {
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.Kotlin.stdlibJvm)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraint)
    implementation(Dependencies.AndroidX.design)
    implementation(Dependencies.AndroidX.legacy)
    implementation(Dependencies.AndroidX.fragment)

    //navigation
    implementation(Dependencies.AndroidX.Navigation.fragmentKtx)
    implementation(Dependencies.AndroidX.Navigation.uiKtx)

    //hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.compiler)
    implementation(Dependencies.Hilt.viewmodel)
    kapt(Dependencies.Hilt.androidCompiler)

    //retrofit
    implementation(Dependencies.Retrofit.gson)
    implementation(Dependencies.Retrofit.gsonConverter)
    implementation(Dependencies.Retrofit.retrofit)

    //okhttp
    implementation(Dependencies.OkHttp.loggingInterceptor)
    implementation(Dependencies.OkHttp.client)

    //paging
    implementation(Dependencies.AndroidX.Paging.ktx)

    //glide
    implementation(Dependencies.Glide.glide)
    annotationProcessor(Dependencies.Glide.ap)

    //room
    implementation(Dependencies.AndroidX.Room.runtime)
    implementation(Dependencies.AndroidX.Room.ktx)
    kapt(Dependencies.AndroidX.Room.compiler)

    //datastore
    implementation(Dependencies.AndroidX.DataStorePreferences.dataStorePreferences)

    //circle Image view
    implementation(Dependencies.CircleImageView.circleImageView)
    testImplementation (Dependencies.Test.junit)
    androidTestImplementation (Dependencies.Test.junitTest)
    androidTestImplementation (Dependencies.Test.espresso)
}