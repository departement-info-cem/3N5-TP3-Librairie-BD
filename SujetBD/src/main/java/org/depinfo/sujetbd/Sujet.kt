package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Un sujet.
 * @param id l'id du sujet.
 */
@Entity
data class Sujet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "contenu_en_bd") var contenu: String = "",
) {
    /**
     * Constructeur d'un Sujet à utiliser.
     */
    @Suppress("unused")
    constructor(contenu: String) : this(0, contenu)
}