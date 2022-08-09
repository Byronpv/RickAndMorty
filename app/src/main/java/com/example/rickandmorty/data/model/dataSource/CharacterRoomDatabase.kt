package com.example.rickandmorty.data.model.dataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.model.dataSource.characteres.CharacterLocalRoomDataSource


@Database(entities = [CharacterLocalRoomDataSource::class], version = 1)
abstract class CharacterRoomDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterLocalRoomDataSource

    companion object {
        private var INSTANCE: CharacterRoomDatabase? = null

        fun getDatabase(context: Context): CharacterRoomDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                CharacterRoomDatabase::class.java,
                "character_table"
            ).build()

            return INSTANCE!!
        }


    }

}