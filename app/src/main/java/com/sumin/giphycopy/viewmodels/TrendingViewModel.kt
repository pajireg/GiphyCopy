package com.sumin.giphycopy.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.giphycopy.api.Data
import com.sumin.giphycopy.api.DataApi
import com.sumin.giphycopy.api.DataProperty
import com.sumin.giphycopy.api.DataService
import kotlinx.coroutines.launch
import java.lang.Exception

class TrendingViewModel : ViewModel() {

    companion object{
        private val TAG = TrendingViewModel::class.toString()
    }
    private val _listData = MutableLiveData<List<Data>>()
    val listData: LiveData<List<Data>>
        get() = _listData
    private val _data = MutableLiveData<DataProperty>()
    val data: LiveData<DataProperty>
        get() = _data

    init {
        getDataProperties()
    }
    private fun getDataProperties() {
        viewModelScope.launch {
            try {
                Log.i(TAG, "getDataProperties")
                _listData.value = DataApi.apiService.getData(25, "g").data
                Log.i(TAG, _listData.value.toString())
            } catch (e: Exception) {
                e.message?.let { Log.e(TAG, it) }
            }
        }
    }
}