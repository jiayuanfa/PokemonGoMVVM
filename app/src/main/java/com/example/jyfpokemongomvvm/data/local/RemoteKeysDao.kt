package com.example.jyfpokemongomvvm.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jyfpokemongomvvm.data.entity.RemoteKeysEntity

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/24
 *     desc  :
 * </pre>
 */
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeysEntity: RemoteKeysEntity)

    @Query("SELECT * FROM RemoteKeysEntity where remoteName = :name")
    suspend fun getRemoteKeys(name: String): RemoteKeysEntity?

    @Query("DELETE FROM RemoteKeysEntity where remoteName = :name")
    suspend fun clearRemoteKey(name: String)
}