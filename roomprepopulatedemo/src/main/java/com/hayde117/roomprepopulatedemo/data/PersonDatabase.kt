package com.hayde117.roomprepopulatedemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hayde117.roomprepopulatedemo.data.Person
import com.hayde117.roomprepopulatedemo.data.PersonDao

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = false
)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

}