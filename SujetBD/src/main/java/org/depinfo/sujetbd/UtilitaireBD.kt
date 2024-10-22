package org.depinfo.sujetbd

import android.content.Context
import androidx.room.Room

/**
 * Utilitaire pour la base de données. Permet d'accéder à la base de données.
 */
@Suppress("unused")
object UtilitaireBD {

    /**
     * Obtenir la base de données.
     * @param ctx le contexte de l'application.
     * @return la base de données.
     */
    fun get(ctx: Context): SujetVoteDataBase {
        return Room.databaseBuilder(ctx, SujetVoteDataBase::class.java, "sujetvote-db").allowMainThreadQueries().build()
    }

    /**
     * Obtenir la base de données pour les tests.
     * @param ctx le contexte de l'application.
     * @return la base de données.
     */
    fun getForTests(ctx: Context): SujetVoteDataBase {
        return Room.inMemoryDatabaseBuilder(ctx, SujetVoteDataBase::class.java).build()
    }
}