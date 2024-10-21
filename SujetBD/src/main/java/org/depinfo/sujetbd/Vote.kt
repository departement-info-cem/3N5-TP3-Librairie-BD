package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["sujetId"])],
    foreignKeys = arrayOf(
    ForeignKey(entity = Sujet::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("sujetId"),
    onDelete = ForeignKey.CASCADE),

))
class Vote {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo()
    var sujetId: Long = 0            // l'id du sujet sur lequel on vote Foreign Key

    @ColumnInfo()
    var nomVotant: String = ""       // le nom du votant qui devra être unique pour cette question

    @ColumnInfo()
    var note: Int = 0               // la note entre 1 et 5
}