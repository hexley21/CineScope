package org.hxl.network.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hxl.network.api.cinema.CinemaService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object ServiceFactory {
    fun createCinema(isDebug: Boolean, baseUrl: String, apiToken: String): CinemaService {
        return createRetrofit(isDebug, baseUrl, apiToken).create(CinemaService::class.java)
    }

    private fun createRetrofit(isDebug: Boolean, baseUrl: String, apiToken: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createOkHttpClient(loggingInterceptor(isDebug), apiToken))
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()
    }

    private fun createOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, apiToken: String): OkHttpClient {
        val TIMEOUT = 60L
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor(apiToken))
            .build()
    }

    private fun loggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (isDebug) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }
}
