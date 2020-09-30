package com.example.jyfpokemongomvvm.data.mapper

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/29
 *     desc  : Map类
 * </pre>
 */
interface Mapper<I, O>{
    fun map(input: I): O
}