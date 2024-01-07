package com.dli46.entertainment.ui.webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dli46.entertainment.App.Companion.DEFAULT_WEBVIEW_URL

class WebviewViewModel : ViewModel() {
    private val _url = MutableLiveData<String>().apply {
        value = DEFAULT_WEBVIEW_URL
    }
    val url: LiveData<String> = _url

    fun setUrl(url: String) {
        _url.value = url
    }
}
