package com.example.gamebacklog.Repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamebacklog.MainActivity.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable ORDER BY year ASC, month ASC, day ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)
}