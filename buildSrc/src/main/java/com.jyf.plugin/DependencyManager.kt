package com.jyf.plugin

object Versions {

    // Hilt
    const val hit = "2.28-alpha"
    const val hitViewModule = "1.0.0-alpha01"

    // DataBinding
    const val jDatabinding = "1.0.1"

    // Kotlin core
    const val coreKtx = "1.3.0"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
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