package org.depinfo.sujetbd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Sujet::class, Vote::class], version = 1)
abstract class SujetVoteDataBase : RoomDatabase() {
    abstract fun dao(): SujetVoteDAO
}