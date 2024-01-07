package com.dli46.entertainment.model

import android.util.Log
import com.google.gson.Gson

private const val TAG = "ColorList"

class Vocabulary : ArrayList<Phrase>()

data class Phrase(val colorId: Int, val hexString: String, val name: String)

class ColorList(jsonString: String) {
    var phrases = ArrayList<Phrase>()

    init {
        val gson = Gson()
        phrases = gson.fromJson(jsonString, Vocabulary::class.java)

        Log.d(TAG, jsonString) // print jsonString to Log
    }
}