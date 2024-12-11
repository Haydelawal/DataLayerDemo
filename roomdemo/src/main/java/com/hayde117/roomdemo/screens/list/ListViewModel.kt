package com.hayde117.roomdemo.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val myRepo: MyRepo
) : ViewModel() {

    private val _allPersons = MutableStateFlow<List<Person>>(value = emptyList())
    val allPersons: StateFlow<List<Person>> = _allPersons

    init {
        readData()
    }

    private fun readData() {
        viewModelScope.launch {
            myRepo.readData().collectLatest {
                _allPersons.value = it
            }
        }
    }

     fun insertData(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            myRepo.insertData(person)
        }
    }

    suspend fun deleteData(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            myRepo.deleteData(person)
        }
    }

    suspend fun updateData(person: Person) {
        return myRepo.updateData(person)
    }

    suspend fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            myRepo.deleteAllData()
        }
    }

    fun searchDatabase(searchQuery: String): Flow<List<Person>> {
        return myRepo.searchDatabase(searchQuery)
    }

    fun orderByAgeDesc(): Flow<List<Person>> {
        return myRepo.orderByAgeDesc()
    }

    fun sortByNames(): Flow<List<Person>> {
        return myRepo.sortByNames()
    }

}