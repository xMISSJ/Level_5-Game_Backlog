package com.example.gamebacklog.Repository

import androidx.room.*
import com.example.gamebacklog.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

}