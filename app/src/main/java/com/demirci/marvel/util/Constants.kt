package com.demirci.marvel.util

import com.demirci.marvel.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val CHARACTER_LIMIT = "30"
        const val ORDER_BY = "focDate"
        const val COMICS_LIMIT = "10"
        const val DATE_RANGE = "2005-01-01,2023-01-01"

        fun hash(): String {
            val input = "$timeStamp${BuildConfig.PRIVATE_KEY}${BuildConfig.API_KEY}"
            val messageDigest = MessageDigest.getInstance("MD5")
            return BigInteger(1, messageDigest.digest(input.toByteArray(Charsets.UTF_8))).toString(
                16
            ).padStart(32, '0')
        }
    }
}