package com.es.tmdb.utility

/**

 * * * * * * * * * * * * * * * * *
 *  Created by Erol Sancaktutan  *
 *    www.erolsancaktutan.com    *
 *   erolsancaktutan@gmail.com   *
 *            11/3/2021          *
 * * * * * * * * * * * * * * * * *

 */

object Constants {
    init {
        System.loadLibrary("native-lib")
    }
    private external fun getBaseURL(): String
    private external fun getPublicApiKey(): String
    val BASE_URL = getBaseURL()
    val PUBLIC_API_KEY = getPublicApiKey()
}