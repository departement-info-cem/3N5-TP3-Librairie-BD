package org.depinfo.sujetbd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Sujet {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L // TODO expliquer que 0 est important ici, convention pour "a generer".

    @ColumnInfo(name = "contenu_en_bd")
    var contenu: String = ""

}