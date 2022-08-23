package com.example.rickandmorty.data.model.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.model.dataSource.characteres.CharacterLocalRoomDataSource

@Dao
interface CharacterRoomDao {
    @Query("SELECT * FROM charactermodelroom")
    suspend fun getAllCharacter():List<CharacterLocalRoomDataSource>
    //test
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(character:CharacterLocalRoomDataSource)

}