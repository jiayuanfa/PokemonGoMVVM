package com.example.jyfpokemongomvvm.ext

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * 把json转为任意对象的泛型方法
 */
fun <T> Gson.typedToJson(src: T): String = toJson(src)
inline fun <reified T: Any> Gson.fromJson(json: String): T = fromJson(json, object : TypeToken<T>(){}.type)

