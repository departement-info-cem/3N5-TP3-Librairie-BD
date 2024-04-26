package ca.cem.tp3_bd

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun premierTest() {
        val context : Context = ApplicationProvider.getApplicationContext<Context>()
        val db : SujetVoteDataBase = Room.inMemoryDatabaseBuilder(
            context, SujetVoteDataBase::class.java).build()
        val dao: SujetVoteDAO = db.dao()
        var s =  Sujet()
        s.contenu = "coucou"
        dao.ajouterSujet(s)
        for (sujet in dao.tousLesSujets()) {
            println(sujet.contenu)
        }
        //assertEquals("ca.cem.info.roomydatabase.test", appContext.packageName)
    }

    @Test
    fun testGrosseQuestion() {
        val context : Context = ApplicationProvider.getApplicationContext<Context>()
        val db : SujetVoteDataBase = Room.inMemoryDatabaseBuilder(
            context, SujetVoteDataBase::class.java).build()
        val dao: SujetVoteDAO = db.dao()

        var s: Sujet =  Sujet()
        s.contenu = "coucou"

        dao.ajouterSujet(s)
        for (sujet in dao.tousLesSujets()) {
            println(sujet.contenu)
        }
        //assertEquals("ca.cem.info.roomydatabase.test", appContext.packageName)
    }

    @Test
    fun ajoutVote() {
        val context : Context = ApplicationProvider.getApplicationContext<Context>()
        val db : SujetVoteDataBase = Room.inMemoryDatabaseBuilder(
            context, SujetVoteDataBase::class.java).build()
        val dao: SujetVoteDAO = db.dao()

        var s: Sujet =  Sujet()
        s.contenu = "coucou"

        val id: Long = dao.ajouterSujet(s)
        for (sujet in dao.tousLesSujets()) {
            println(sujet.contenu)
        }
        //assertEquals("ca.cem.info.roomydatabase.test", appContext.packageName)
    }
}