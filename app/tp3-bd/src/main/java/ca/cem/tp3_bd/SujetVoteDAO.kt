package ca.cem.tp3_bd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.Optional

@Dao
interface SujetVoteDAO {


    @Insert fun ajouterSujet(sujet: Sujet): Long
    @Insert fun ajouterVote(vote: Vote): Long
    @Query("SELECT * FROM sujet")
    fun tousLesSujets(): List<Sujet>

    // trouver un sujet qui a le meme contenu
    @Query("SELECT * FROM sujet WHERE sujet.contenu_en_bd = :contenu")
    fun sujetParContenu(contenu: String): Optional<Sujet>

    @Query("SELECT * FROM vote WHERE vote.sujetId = :sujetID")
    fun votesPourCeSujet(sujetID: Long ): List<Vote>

    @Query("SELECT * FROM vote WHERE vote.sujetId = :sujetID AND vote.nomVotant = :votant")
    fun votePourCeSujetCeVotant(sujetID: Long, votant: String ): Optional<Vote>

    @Query("SELECT * FROM sujet WHERE id = :id")
    fun sujetParSonID(id: Long): Sujet?

    // Dev part
    // TODO handle cascade delete on votes
    @Delete
    fun supprimer(sujet: Sujet)

    // return all sujets ordered by number of votes
    @Query("SELECT * FROM sujet ORDER BY (SELECT COUNT(*) FROM vote WHERE vote.sujetId = sujet.id) DESC")
    fun sujetsParOrdreDeVotes(): List<Sujet>
}