package com.example.gamebacklog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game (
    val title: String,
    val platform: String,

    val day: Int,
    val month: Int,
    val year: Int

) : Parcelable