package ca.cem.sujetbd

import android.content.Context
import androidx.room.Room

object UtilitaireBD {

    fun get(ctx: Context): SujetVoteDataBase {
        return Room.databaseBuilder(ctx, SujetVoteDataBase::class.java, "sujetvote-db").allowMainThreadQueries().build()
    }

    fun getForTests(ctx: Context): SujetVoteDataBase {
        return Room.inMemoryDatabaseBuilder(ctx, SujetVoteDataBase::class.java).build()
    }
}