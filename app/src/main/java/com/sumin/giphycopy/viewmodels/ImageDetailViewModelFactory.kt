package com.sumin.giphycopy.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sumin.giphycopy.data.Data

class ImageDetailViewModelFactory(private val data: Data, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageDetailViewModel(data, application) as T
    }
}