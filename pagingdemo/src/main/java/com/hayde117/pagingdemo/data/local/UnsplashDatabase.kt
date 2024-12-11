package com.hayde117.pagingdemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hayde117.pagingdemo.data.local.dao.UnsplashImageDao
import com.hayde117.pagingdemo.data.local.dao.UnsplashRemoteKeysDao
import com.hayde117.pagingdemo.model.UnsplashImage
import com.hayde117.pagingdemo.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1, exportSchema = false)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}