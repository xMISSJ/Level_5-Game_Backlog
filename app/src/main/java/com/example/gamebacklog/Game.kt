package com.example.gamebacklog

import android.os.Parcelable
import androidx.annotation.IntRange
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game (
    val title: String,
    val platform: String,

    @IntRange (from = 1, to = 31)
    val day: Int,

    @IntRange (from = 1, to = 12)
    val month: Int,

    @IntRange (from = 1900, to = 2100)
    val year: Int

) : Parcelable