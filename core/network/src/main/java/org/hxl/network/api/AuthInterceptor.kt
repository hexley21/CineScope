package org.hxl.network.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(private val apiToken: String) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val modifiedRequest: Request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $apiToken")
            .header("Accept", "application/json") // Add the "accept" header
            .build()
        return chain.proceed(modifiedRequest)
    }
}
