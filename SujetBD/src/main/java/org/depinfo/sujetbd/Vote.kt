package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Sujet::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("sujetId"),
    onDelete = ForeignKey.CASCADE)
))
class Vote {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo()
    var sujetId: Long? = null            // l'id du sujet sur lequel on vote Foreign Key

    @ColumnInfo()
    var nomVotant: String? = null       // le nom du votant qui devra être unique pour cette question

    @ColumnInfo()
    var note: Int? = null               // la note entre 1 et 5
}