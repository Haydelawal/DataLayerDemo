package com.hayde117.roomdemo.repository

import com.hayde117.roomdemo.data.Person
import kotlinx.coroutines.flow.Flow

interface MyRepo {

    fun readData(): Flow<List<Person>>

    suspend fun insertData(person: Person)

    suspend fun deleteData(person: Person)

    suspend fun updateData(person: Person)

    suspend fun deleteAllData()

    fun searchDatabase(searchQuery: String): Flow<List<Person>>

    fun orderByAgeDesc(): Flow<List<Person>>

    fun sortByNames(): Flow<List<Person>>

}