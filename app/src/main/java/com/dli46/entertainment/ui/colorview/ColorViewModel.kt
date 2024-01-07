package com.dli46.entertainment.ui.colorview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dli46.entertainment.model.ColorList
import com.dli46.entertainment.model.Phrase


private const val TAG = "ColorViewModel"

class ColorViewModel(app: Application) : AndroidViewModel(app) {

    private var colorList: ColorList

    private val _vocabulary = MutableLiveData<List<Phrase>>()
    var vocabulary: LiveData<List<Phrase>> = _vocabulary

    init {
        val jsonString = app.assets.open("data.json").bufferedReader().use { it.readText() }

        colorList = ColorList(jsonString)

        _vocabulary.value = colorList.phrases

        Log.d(TAG, jsonString) // prints jsonString to Log
    }

}