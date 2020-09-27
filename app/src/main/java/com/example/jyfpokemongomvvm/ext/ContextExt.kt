@file:Suppress("UNCHECKED_CAST")

package com.example.jyfpokemongomvvm.ext

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Activity判断是否连接网络
 */
@Suppress("DEPRECATION")
@SuppressLint("MissingPermission")
fun Context.isConnectedNetwork() : Boolean = run {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    activeNetwork?.isConnectedOrConnecting == true
}

inline fun <T> String.getEmptyOrDefault(default: () -> T) : T {
    return if (isNullOrEmpty() || this == "null") {
        default()
    } else {
        this as T
    }
}