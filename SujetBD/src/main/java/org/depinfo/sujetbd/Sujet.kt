package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sujet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "contenu_en_bd") var contenu: String = "",
) {
    @Suppress("unused")
    constructor(contenu: String) : this(0, contenu)
}