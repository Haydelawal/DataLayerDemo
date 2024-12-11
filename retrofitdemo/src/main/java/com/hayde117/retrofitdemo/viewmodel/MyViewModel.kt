package com.hayde117.retrofitdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayde117.retrofitdemo.model.MyPost
import com.hayde117.retrofitdemo.repository.MyRepo
import com.hayde117.retrofitdemo.utils.Constants.Exception_TAG
import com.hayde117.retrofitdemo.utils.Constants.HttpException_TAG
import com.hayde117.retrofitdemo.utils.Constants.IOException_TAG
import com.hayde117.retrofitdemo.utils.NetworkResult
import com.hayde117.retrofitdemo.viewmodel.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val myRepo: MyRepo,
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

    private val _myResponseFlow = MutableStateFlow<NetworkResult<MyPost>>(NetworkResult.Loading())
    val myResponseFlow: StateFlow<NetworkResult<MyPost>> = _myResponseFlow

    val isConnected = connectivityObserver
        .isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
        )


     fun fetchApiResult() {
        viewModelScope.launch {
            _myResponseFlow.value = NetworkResult.Loading()

                try {
                    val response = myRepo.getPost()
                    if (response.isSuccessful) {
                        _myResponseFlow.value = NetworkResult.Success(response.body()!!)
                    } else {
                        _myResponseFlow.value = NetworkResult.Error(response.message())
                    }
                }catch (e: IOException) {
                    _myResponseFlow.value = NetworkResult.Error(e.message)
                    Log.d(IOException_TAG, "Exception $e")
                } catch (e: HttpException) {
                    _myResponseFlow.value = NetworkResult.Error(e.message)
                    Log.d(HttpException_TAG, "Exception $e")

                } catch (e: Exception) {
                    _myResponseFlow.value = NetworkResult.Error(e.message)

                    Log.d(Exception_TAG, "Exception $e")
                }

        }
    }

}
