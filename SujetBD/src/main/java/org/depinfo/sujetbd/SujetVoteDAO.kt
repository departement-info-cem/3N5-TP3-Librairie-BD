package org.depinfo.sujetbd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.Optional

/**
 * DAO pour les sujets et les votes.
 */
@Dao
interface SujetVoteDAO {

    /**
     * Ajouter un sujet.
     * @param sujet le sujet à ajouter.
     * @return l'id du sujet ajouté.
     */
    @Insert fun ajouterSujet(sujet: Sujet): Long

    /**
     * Ajouter un vote.
     * @param vote le vote à ajouter.
     * @return l'id du vote ajouté.
     */
    @Insert fun ajouterVote(vote: Vote): Long

    /**
     * Obtenir l'ensemble des sujets de l'application.
     * @return la liste des sujets.
     */
    @Query("SELECT * FROM sujet")
    fun tousLesSujets(): List<Sujet>

    /**
     * Obtenir un sujet selon son contenu.
     * @param contenu le contenu du sujet.
     * @return le sujet trouvé, ou null si aucun sujet ne correspond au contenu demandé.
     */
    @Query("SELECT * FROM sujet WHERE sujet.contenu_en_bd = :contenu")
    fun sujetParContenu(contenu: String): Optional<Sujet>

    /**
     * Obtenir les votes d'un sujet.
     * @param sujetID l'id du sujet.
     * @return la liste des votes pour ce sujet.
     */
    @Query("SELECT * FROM vote WHERE vote.sujetId = :sujetID")
    fun votesPourCeSujet(sujetID: Long ): List<Vote>

    /**
     * Obtenir le vote d'un votant pour un sujet.
     * @param sujetID l'id du sujet.
     * @param votant le nom du votant.
     * @return le vote du votant pour ce sujet, ou null si la paire votant/sujet n'existe pas.
     */
    @Query("SELECT * FROM vote WHERE vote.sujetId = :sujetID AND vote.nomVotant = :votant")
    fun votePourCeSujetCeVotant(sujetID: Long, votant: String ): Optional<Vote>

    /**
     * Obtenir un sujet selon son ID.
     * @param id l'id du sujet.
     * @return le sujet trouvé, ou null si aucun sujet ne correspond à l'id demandé.
     */
    @Query("SELECT * FROM sujet WHERE id = :id")
    fun sujetParSonID(id: Long): Sujet?

    /**
     * Supprimer un sujet.
     * @param sujet le sujet à supprimer.
     */
    @Delete
    fun supprimer(sujet: Sujet)

    /**
     * Supprimer tous les sujets, ainsi que tous les votes associés.
     */
    @Query("DELETE FROM sujet")
    fun supprimerTousLesSujets()

    /**
     * Supprimer tous les votes de tous les sujets.
     */
    @Query("DELETE FROM vote")
    fun supprimerTousLesVotes()

    /**
     * Obtenir tous les sujets par ordre de votes.
     */
    @Query("SELECT * FROM sujet ORDER BY (SELECT COUNT(*) FROM vote WHERE vote.sujetId = sujet.id) DESC")
    fun sujetsParOrdreDeVotes(): List<Sujet>

    /**
     * Obtenir tous les votes
     * @return la liste de tous les votes.
     */
    @Query("SELECT * FROM vote")
    fun tousLesVotes(): List<Vote>

    /**
     * Obtenir le nombre de votes pour un sujet.
     * @param sujetID l'id du sujet.
     * @return le nombre de votes pour ce sujet.
     */
    @Query("SELECT COUNT(*) FROM vote WHERE vote.sujetId = :sujetID")
    fun nombreDeVotesPourCeSujet(sujetID: Long): Int

    /**
     * Obtenir le nombre total de votes.
     * @return le nombre total de votes.
     */
    @Query("SELECT COUNT(*) FROM vote")
    fun nombreTotalDeVotes(): Int

    /**
     * Obtenir le nombre total de sujets.
     * @return le nombre total de sujets.
     */
    @Query("SELECT COUNT(*) FROM sujet")
    fun nombreTotalDeSujets(): Int

    /**
     * Obtenir le nombre total de votants.
     * @return le nombre total de votants.
     */
    @Query("SELECT COUNT(DISTINCT nomVotant) FROM vote")
    fun nombreTotalDeVotants(): Int
}