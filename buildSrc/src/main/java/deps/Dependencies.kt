package deps

object Dependencies {
    object Kotlin {
        val version = "1.3.72"
        val coroutinesVersion = "1.3.6"
        val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object GradlePlugin {
        val android = "com.android.tools.build:gradle:4.0.0"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
        val playServices = "com.google.gms:google-services:4.3.3"
        val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidX.Navigation.version}"
        val jetifier = "com.android.tools.build.jetifier:jetifier-processor:1.0.0-beta05"
        val licensesPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.0"
        val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
        val iconRibbonPlugin = "com.akaita.android:easylauncher:1.3.1"
        val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:0.22.0"
    }

    object Test {
        val junit = "junit:junit:4.12"
        val junitTest = "androidx.test.ext:junit:1.1.2"
        val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        val junitRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object AndroidX {
        val jetifier = "com.android.tools.build.jetifier:jetifier-core:1.0.0-beta02"
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha02"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
        val design = "com.google.android.material:material:1.2.0-alpha05"
        val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"
        val preference = "androidx.preference:preference:1.1.0"
        val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.2"
        val fragment = "androidx.fragment:fragment:1.3.0-alpha08"
        val recyclerViewAnimation = "jp.wasabeef:recyclerview-animators:3.0.0"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

        object Room {
            const val version = "2.3.0-alpha02"
            val compiler = "androidx.room:room-compiler:$version"
            val runtime = "androidx.room:room-runtime:$version"
            val ktx = "androidx.room:room-ktx:$version"
        }

        object Navigation {
            val version = "2.2.1"
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Paging {
            val version = "3.0.0-alpha11"
            val runtime = "androidx.paging:paging-runtime:$version"
            val ktx = "androidx.paging:paging-runtime-ktx:$version"
        }

        object DataStorePreferences{

            val dataStorePreferences = "androidx.datastore:datastore-preferences:1.0.0-alpha05"
        }
    }

    object OkHttp {
        val version = "4.7.2"
        val client = "com.squareup.okhttp3:okhttp:$version"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        val okio = "com.squareup.okio:okio:1.14.0"
    }
    object Hilt {
        val hiltVersion = "2.28-alpha"
        val hiltAndroidXVersion = "1.0.0-alpha01"
        val android = "com.google.dagger:hilt-android:$hiltVersion"
        val compiler = "androidx.hilt:hilt-compiler:$hiltAndroidXVersion"
        val androidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidXVersion"
    }

    object Retrofit {
        private const val version = "2.8.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val gson = "com.google.code.gson:gson:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val ap = "com.github.bumptech.glide:compiler:$version"
    }
    object CircleImageView {
        const val circleImageView = "de.hdodenhof:circleimageview:3.1.0"
    }

}