package com.hayde117.roomdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.data.PersonDao

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = false
)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

}