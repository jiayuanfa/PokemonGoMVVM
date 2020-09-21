package com.example.jyfpokemongomvvm

import android.content.Context

/**
 * 单例类
 * 便捷获取Context
 */
object AppHelper {

    lateinit var mContext: Context

    fun init(context: Context) {
        this.mContext = context
    }
}