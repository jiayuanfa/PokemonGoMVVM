package com.example.jyfpokemongomvvm.init

import android.content.Context
import android.os.StrictMode
import androidx.startup.Initializer
import com.example.jyfpokemongomvvm.AppHelper
import com.example.jyfpokemongomvvm.BuildConfig
import timber.log.Timber

class AppInitializer :  Initializer<Unit>{
    override fun create(context: Context) {
        if (!BuildConfig.DEBUG) {
            return
        }
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build()
        )
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
        Timber.plant(Timber.DebugTree())
        AppHelper.init(context)
        return Unit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}