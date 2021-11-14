package com.example.geegbrainsprofessional.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.geegbrainsprofessional.data.database.dao.DefinitionDao
import com.example.geegbrainsprofessional.data.database.table.Definition
import com.example.geegbrainsprofessional.data.database.table.Meanings


@Database(entities = [Definition::class, Meanings::class], version = 1, exportSchema = true)
abstract class DataBase : RoomDatabase() {
    abstract fun definitionDao(): DefinitionDao
}