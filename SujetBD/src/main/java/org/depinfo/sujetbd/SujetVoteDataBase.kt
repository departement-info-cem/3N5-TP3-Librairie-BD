package org.depinfo.sujetbd

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * La base de données.
 */
@Database(entities = [Sujet::class, Vote::class], version = 1, exportSchema = false)
abstract class SujetVoteDataBase : RoomDatabase() {
    /**
     * Obtenir le DAO.
     * @return le DAO.
     */
    abstract fun dao(): SujetVoteDAO
}