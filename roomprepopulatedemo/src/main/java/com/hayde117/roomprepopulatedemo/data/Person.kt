package com.hayde117.roomprepopulatedemo.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.text.DateFormat

@Parcelize
@Serializable
@Entity(tableName = "person_table")
data class Person(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,

    val gender: String,
    val age: String
) : Parcelable