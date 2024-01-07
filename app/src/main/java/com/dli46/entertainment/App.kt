package com.dli46.entertainment

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var instance: App
        const val BASE_URL = "https://www.boredapi.com/"
        const val KEY = "5881028"
        const val TYPE = "recreational"

        const val SHOW_MESSAGE_AT_START = "show_message_at_start"
        const val SHOW_NOW_IMAGE = "show_now_image"
        const val EFFECT_SELECTION = "effect_selection"

        const val DEFAULT_WEBVIEW_URL = "https://history.nasa.gov/"
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}