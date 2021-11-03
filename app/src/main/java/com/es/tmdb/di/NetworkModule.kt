package com.es.tmdb.di

import com.es.tmdb.network.ApiService
import com.es.tmdb.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): ApiService {
        val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val orginal = chain.request()
            val orginalHttpUrl = orginal.url()
            val url = orginalHttpUrl.newBuilder()
                .addQueryParameter("api_key", Constants.API_KEY)
                .build()

            val requestBuilder = orginal.newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .method(orginal.method(), orginal.body())
                .url(url)

            val request = requestBuilder.build()

            chain.proceed(request)
        }.connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient).build()

        return retrofit.create(ApiService::class.java)
    }
}