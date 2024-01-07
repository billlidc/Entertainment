package com.dli46.entertainment.bored

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredApi {
    // From Bored Documentation, cited: https://www.boredapi.com/documentation

    /**
     * Fetches response according to different inputs
     */
    @GET("api/activity")
    fun fetchActivityRandom(
    ): Call<BoredResponse>

    @GET("api/activity")
    fun fetchActivityWithKey(
        @Query("key") key: String,
    ): Call<BoredResponse>

    @GET("api/activity")
    fun fetchActivityWithType(
        @Query("type") type: String,
    ): Call<BoredResponse>

    @GET("api/activity")
    fun fetchActivityWithParticipants(
        @Query("participants") participants: Int,
    ): Call<BoredResponse>

//    @GET("api/activity")
//    fun fetchActivityWithPrice(
//        @Query("price") price: Double,
//    ): Call<BoredResponse>

//    @GET("api/activity")
//    fun fetchActivityWithPriceRange(
//        @Query("minprice") minprice: Double,
//        @Query("maxprice") maxprice: Double,
//    ): Call<BoredResponse>
//
//    @GET("api/activity")
//    fun fetchActivityWithAccessibility(
//        @Query("accessibility") accessibility: Double,
//    ): Call<BoredResponse>
//
//    @GET("api/activity")
//    fun fetchActivityWithAccessibilityRange(
//        @Query("minaccessibility") minaccessibility: Double,
//        @Query("maxaccessibility") maxaccessibility: Double,
//    ): Call<BoredResponse>


//    @GET("api/activity")
//    fun fetchActivity(
//        @Query("activity") activity: String,
//        @Query("accessibility") accessibility: Double,
//        @Query("type") type: String,
//        @Query("participants") participants: Int,
//        @Query("price") price: String,
//        @Query("link") link: String,
//        @Query("key") key: String,
//    ): Call<BoredResponse>
}