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
}

object Hilt {
    const val daggerRuntime = "com.google.dagger:hilt-android:${Versions.hit}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hit}"
    const val viewModule = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hitViewModule}"
    const val compiler = "androidx.hilt:hilt-compiler:${Versions.hitViewModule}"
}

object Depend {
    const val jDatabinding = "com.hi-dhl:jdatabinding:${Versions.jDatabinding}"
}

object Anko {
    const val common = "org.jetbrains.anko:anko-common:${Versions.anko}"
    const val sqlite = "org.jetbrains.anko:anko-sqlite:${Versions.anko}"
    const val coroutines = "org.jetbrains.anko:anko-coroutines:${Versions.anko}"
    const val design = "org.jetbrains.anko:anko-design:${Versions.anko}" // For SnackBars
}