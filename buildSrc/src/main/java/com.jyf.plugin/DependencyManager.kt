package com.jyf.plugin

object Versions {

    // Kotlin
    const val kotlin = "1.3.72"

    // Hilt
    const val hit = "2.28-alpha"
    const val hitViewModule = "1.0.0-alpha01"

    // DataBinding
    const val jDatabinding = "1.0.1"

    // Kotlin core
    const val coreKtx = "1.3.0"

    // Anko coroutines 协程
    const val anko = "0.10.8"

    // Coil图片加载库 + 协程
    const val runtime = "0.11.0"

    // Paging3数据管理框架
    const val paging = "3.0.0-alpha02"

    // Retrofit、gson
    const val retrofit = "2.9.0"

    // Room 数据库
    const val room = "2.3.0-alpha01"

    const val fragment = "1.3.0-alpha06"

    // 下拉刷新库
    const val swiperefreshlayout = "1.0.0"

    // Timber
    const val timber = "4.7.1"

    const val progressview = "1.0.0"

    const val appStartup = "1.0.0-alpha01"
}

object Fragment {
    const val runtimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
    const val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val testing = "androidx.room:room-testing:${Versions.room}"
}

object Retrofit {
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
//    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
}

object Coil {
    const val runtime = "io.coil-kt:coil:${Versions.runtime}"
}

object Kt {
    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val appStartup = "androidx.startup:startup-runtime:${Versions.appStartup}"
}

object Hilt {
    const val daggerRuntime = "com.google.dagger:hilt-android:${Versions.hit}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hit}"
    const val viewModule = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hitViewModule}"
    const val compiler = "androidx.hilt:hilt-compiler:${Versions.hitViewModule}"
}

object Depend {
    const val jDatabinding = "com.hi-dhl:jdatabinding:${Versions.jDatabinding}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val progressview = "com.hi-dhl:progressview:${Versions.progressview}"
}

object Anko {
    const val common = "org.jetbrains.anko:anko-common:${Versions.anko}"
    const val sqlite = "org.jetbrains.anko:anko-sqlite:${Versions.anko}"
    const val coroutines = "org.jetbrains.anko:anko-coroutines:${Versions.anko}"
    const val design = "org.jetbrains.anko:anko-design:${Versions.anko}" // For SnackBars
}