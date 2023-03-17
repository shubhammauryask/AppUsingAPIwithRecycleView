package com.example.api26

import retrofit2.Call
import retrofit2.http.GET


interface Apiinterface {

    @GET("products")
    fun getProductData(): Call<Mydata>
}