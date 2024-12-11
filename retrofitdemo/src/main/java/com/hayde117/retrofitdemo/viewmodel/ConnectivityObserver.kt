package com.hayde117.retrofitdemo.viewmodel

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    val isConnected: Flow<Boolean>
}