package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Un vote pour un sujet
 * @param id l'id du vote
 * @param sujetId l'id du sujet sur lequel on vote
 * @param nomVotant le nom du votant qui devra être unique pour cette question
 * @param note la note entre 1 et 5
 */
@Entity(
    indices = [Index(value = ["sujetId"])], foreignKeys = [ForeignKey(
        entity = Sujet::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("sujetId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Vote(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo() var sujetId: Long = 0,            // l'id du sujet sur lequel on vote Foreign Key
    @ColumnInfo() var nomVotant: String = "",       // le nom du votant qui devra être unique pour cette question
    @ColumnInfo() var note: Int = 0,              // la note entre 1 et 5
) {
    @Suppress("unused")
    constructor(sujetId: Long, nomVotant: String, note: Int) : this(0, sujetId, nomVotant, note)
}