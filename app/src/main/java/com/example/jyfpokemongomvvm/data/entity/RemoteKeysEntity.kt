package com.example.jyfpokemongomvvm.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/24
 *     desc  :
 * </pre>
 */
@Entity
data class RemoteKeysEntity(
    @PrimaryKey
    val remoteName: String,
    val nextKey: Int?
)