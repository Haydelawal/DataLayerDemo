package com.hayde117.roomdemo.di.database

import android.content.Context
import androidx.room.Room
import com.hayde117.roomdemo.data.PersonDatabase
import com.hayde117.roomdemo.repository.MyRepo
import com.hayde117.roomdemo.repository.MyRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PersonDatabase::class.java,
        "person_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()


    // Provide the repository interface implementation
    @Provides
    @Singleton
    fun provideMyRepo(myRepoImpl: MyRepoImpl): MyRepo {
        return myRepoImpl
    }
}