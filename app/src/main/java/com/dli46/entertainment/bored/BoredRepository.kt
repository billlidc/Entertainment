package com.dli46.entertainment.bored

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dli46.entertainment.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "BoredRepository"

class BoredRepository {

//    private val _activity = MutableLiveData<String>()
//    var activity: LiveData<String> = _activity
//
//    private val _type = MutableLiveData<String>()
//    var type: LiveData<String> = _type
//
//    private val _participants = MutableLiveData<Int>()
//    var participants: LiveData<Int> = _participants
//
//    private val _price = MutableLiveData<Double>()
//    var price: LiveData<Double> = _price
//
//    private val _link = MutableLiveData<String>()
//    var link: LiveData<String> = _link
//
//    private val _key = MutableLiveData<String>()
//    var key: LiveData<String> = _key
//
//    private val _accessibility = MutableLiveData<Double>()
//    var accessibility: LiveData<Double> = _accessibility
//
//
//    companion object {
//        val boredApi: BoredApi by lazy {
//            val retrofit: Retrofit = Retrofit.Builder()
//                .baseUrl(App.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            return@lazy retrofit.create(BoredApi::class.java)
//        }
//    }
//
//
//
//    fun fetchActivityRandom() {
//        val request: Call<BoredResponse> = BoredRepository.boredApi.fetchActivityRandom(
//        )
//        request.enqueue(object : Callback<BoredResponse> {
//            override fun onResponse(call: Call<BoredResponse>, response: Response<BoredResponse>) {
//
//                _activity.value = ""
//                _type.value = ""
//                _participants.value = 0
//                _price.value = 0.0
//                _link.value = ""
//                _key.value = ""
//                _accessibility.value = 0.0
//
//                // An HTTP response may still indicate an application-level failure such as a 404 or 500.
//                // Call Response.isSuccessful() to determine if the response indicates success.
////                if (response.isSuccessful) {
//                val newResponse: BoredResponse? = response.body()
//                newResponse?.let {
//                    _activity.value = it.activity
//                    _type.value = it.type
//                    _participants.value = it.participants
//                    _price.value = it.price
//                    _link.value = it.link
//                    _key.value = it.key
//                    _accessibility.value = it.accessibility
////                        Log.d(TAG, "new_activity: $_response.value")
////                        Log.d(TAG, "new_activity: ${newResponseActivity.activity}")
////                    }
//                }
//
//            }
//            override fun onFailure(call: Call<BoredResponse>, t: Throwable) {
//                Log.d(TAG, "Failed to fetch data! Error: $t")
//            }
//        })
//    }
//
//
//    fun fetchActivityWithKey(key: String) {
//        val request: Call<BoredResponse> = boredApi.fetchActivityWithKey(
//            key = key
//        )
//        request.enqueue(object : Callback<BoredResponse> {
//            override fun onResponse(call: Call<BoredResponse>, response: Response<BoredResponse>) {
//
//                _activity.value = ""
//                _type.value = ""
//                _participants.value = 0
//                _price.value = 0.0
//                _link.value = ""
//                _key.value = ""
//                _accessibility.value = 0.0
//
//                // An HTTP response may still indicate an application-level failure such as a 404 or 500.
//                // Call Response.isSuccessful() to determine if the response indicates success.
////                if (response.isSuccessful) {
//                val newResponse: BoredResponse? = response.body()
//                newResponse?.let {
//                    _activity.value = it.activity
//                    _type.value = it.type
//                    _participants.value = it.participants
//                    _price.value = it.price
//                    _link.value = it.link
//                    _key.value = it.key
//                    _accessibility.value = it.accessibility
////                        Log.d(TAG, "new_activity: $_response.value")
////                        Log.d(TAG, "new_activity: ${newResponseActivity.activity}")
////                    }
//                }
//
//            }
//            override fun onFailure(call: Call<BoredResponse>, t: Throwable) {
//                Log.d(TAG, "Failed to fetch data! Error: $t")
//            }
//        })
//    }
//
//    fun fetchActivityWithType(type: String) {
//        val request: Call<BoredResponse> = boredApi.fetchActivityWithType(
//            type = type
//        )
//        request.enqueue(object : Callback<BoredResponse> {
//            override fun onResponse(call: Call<BoredResponse>, response: Response<BoredResponse>) {
//
//                _activity.value = ""
//                _type.value = ""
//                _participants.value = 0
//                _price.value = 0.0
//                _link.value = ""
//                _key.value = ""
//                _accessibility.value = 0.0
//
//                // An HTTP response may still indicate an application-level failure such as a 404 or 500.
//                // Call Response.isSuccessful() to determine if the response indicates success.
////                if (response.isSuccessful) {
//                val newResponse: BoredResponse? = response.body()
//                newResponse?.let {
//                    _activity.value = it.activity
//                    _type.value = it.type
//                    _participants.value = it.participants
//                    _price.value = it.price
//                    _link.value = it.link
//                    _key.value = it.key
//                    _accessibility.value = it.accessibility
////                        Log.d(TAG, "new_activity: $_response.value")
////                        Log.d(TAG, "new_activity: ${newResponseActivity.activity}")
////                    }
//                }
//
//            }
//            override fun onFailure(call: Call<BoredResponse>, t: Throwable) {
//                Log.d(TAG, "Failed to fetch data! Error: $t")
//            }
//        })
//    }
//
//
//    fun fetchActivityWithParticipants(participants: String) {
//        val request: Call<BoredResponse> = boredApi.fetchActivityWithParticipants(
//            participants = participants.toInt()
//        )
//        request.enqueue(object : Callback<BoredResponse> {
//            override fun onResponse(call: Call<BoredResponse>, response: Response<BoredResponse>) {
//
//                _activity.value = ""
//                _type.value = ""
//                _participants.value = 0
//                _price.value = 0.0
//                _link.value = ""
//                _key.value = ""
//                _accessibility.value = 0.0
//
//                // An HTTP response may still indicate an application-level failure such as a 404 or 500.
//                // Call Response.isSuccessful() to determine if the response indicates success.
////                if (response.isSuccessful) {
//                val newResponse: BoredResponse? = response.body()
//                newResponse?.let {
//                    _activity.value = it.activity
//                    _type.value = it.type
//                    _participants.value = it.participants
//                    _price.value = it.price
//                    _link.value = it.link
//                    _key.value = it.key
//                    _accessibility.value = it.accessibility
////                        Log.d(TAG, "new_activity: $_response.value")
////                        Log.d(TAG, "new_activity: ${newResponseActivity.activity}")
////                    }
//                }
//
//            }
//            override fun onFailure(call: Call<BoredResponse>, t: Throwable) {
//                Log.d(TAG, "Failed to fetch data! Error: $t")
//            }
//        })
//    }

}