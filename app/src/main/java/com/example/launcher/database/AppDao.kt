package com.example.launcher.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM apps ORDER BY gridPosition ASC")
    fun observeApps(): Flow<List<AppEntity>>

    @Upsert
    suspend fun upsertAll(apps: List<AppEntity>)

    @Query("DELETE FROM apps WHERE packageName = :packageName")
    suspend fun delete(packageName: String)
}
