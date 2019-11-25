package com.example.gamebacklog.MainActivity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "gameTable")
data class Game (

    val title: String,
    val platform: String,

    val day: Int,
    val month: String,
    val year: Int,

@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")
var id: Long? = null

) : Parcelable