package com.demirci.marvel.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "aac6883646e2108adcfb4890228767cd"
        const val PRIVATE_KEY = "b9dc04b81a8fff16764bc94288dbde96cd102420"
        const val CHARACTER_LIMIT = "30"
        const val ORDER_BY = "focDate"
        const val COMICS_LIMIT = "10"
        const val DATE_RANGE = "2005-01-01,2023-01-01"

        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val messageDigest = MessageDigest.getInstance("MD5")
            return BigInteger(1, messageDigest.digest(input.toByteArray(Charsets.UTF_8))).toString(
                16
            ).padStart(32, '0')
        }
    }
}