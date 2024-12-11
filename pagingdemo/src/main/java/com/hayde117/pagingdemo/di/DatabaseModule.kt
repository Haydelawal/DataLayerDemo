package com.hayde117.pagingdemo.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.hayde117.pagingdemo.data.local.UnsplashDatabase
import com.hayde117.pagingdemo.data.repository.Repository
import com.hayde117.pagingdemo.data.repository.RepositoryImpl
import com.hayde117.pagingdemo.util.Constants.UNSPLASH_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }

    // Provide the repository interface implementation
    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideMyRepo(myRepositoryImpl: RepositoryImpl): Repository {
        return myRepositoryImpl
    }
}