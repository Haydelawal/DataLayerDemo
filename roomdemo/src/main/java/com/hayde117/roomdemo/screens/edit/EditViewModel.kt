package com.hayde117.roomdemo.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val myRepo: MyRepo
) : ViewModel() {

    fun deleteData(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            myRepo.deleteData(person)
        }
    }

    fun updateData(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
         myRepo.updateData(person)
        }
    }
}