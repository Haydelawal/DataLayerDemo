package com.hayde117.roomdemo.repository

import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.data.PersonDao
import com.hayde117.roomdemo.repository.MyRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MyRepoImpl @Inject constructor(private val personDao: PersonDao) : MyRepo {
    override fun readData(): Flow<List<Person>> {
        return personDao.readData()
    }

    override suspend fun insertData(person: Person) {
        return personDao.insertData(person)
    }

    override suspend fun deleteData(person: Person) {
        return personDao.deleteData(person)
    }

    override suspend fun updateData(person: Person) {
      return personDao.updateData(person)
    }

    override suspend fun deleteAllData() {
       return personDao.deleteAllData()
    }

    override fun searchDatabase(searchQuery: String): Flow<List<Person>> {
      return personDao.searchDatabase(searchQuery)
    }

    override fun orderByAgeDesc(): Flow<List<Person>> {
       return personDao.orderByAgeDesc()
    }

    override fun sortByNames(): Flow<List<Person>> {
        return personDao.sortByNames()
    }

}