package com.dli46.entertainment.bored

/*
    {
	"activity": "Learn Express.js",
	"accessibility": 0.25,
	"type": "education",
	"participants": 1,
	"price": 0.1,
	"link": "https://expressjs.com/",
	"key": "3943506"
    }
 */

/**
 * Retrieve activity response
 */


class BoredResponse(
    val activity: String = "",
    val type: String = "",
    val participants: Int = 0,
    val price: Double = 0.0,
    val link: String = "",
    val key: String = "",
    val accessibility: Double = 0.0,
)

//class BoredResponse {
//    val profile: Profile? = null
//}
//