package com.sumin.giphycopy.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.giphycopy.api.DataApi
import com.sumin.giphycopy.data.Data
import kotlinx.coroutines.launch

class TrendingViewModel : ViewModel() {

    companion object{
        private val TAG = TrendingViewModel::class.toString()
    }
    private val _listData = MutableLiveData<List<Data>>()
    val listData: LiveData<List<Data>>
        get() = _listData

    private val _navigateToImageDetail = MutableLiveData<Data>()
    val navigateToImageDetail: LiveData<Data>
        get() = _navigateToImageDetail

    init {
        getDataProperties()
    }
    private fun getDataProperties() {
        viewModelScope.launch {
            try {
                _listData.value = DataApi.apiService.getData(50, "g").data
                Log.i(TAG, "getDataProperties")
            } catch (e: Exception) {
                e.message?.let { Log.e(TAG, it) }
            }
        }
    }
    // 이미지 버튼 누르면 상세화면 전환하기
    fun displayImageDetail(data: Data) {
        _navigateToImageDetail.value = data
    }
    // 상세화면 보여주기 완료되면
    fun displayImageDetailComplete() {
        _navigateToImageDetail.value = null
    }
}