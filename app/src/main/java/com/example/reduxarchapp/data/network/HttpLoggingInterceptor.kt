package com.example.reduxarchapp.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HttpLoggingInterceptor : Interceptor {

    private val apiKey = "k_jkygze98"

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newUrl = original.url.newBuilder().addPathSegment(apiKey).build()
        val newRequest = original.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}
