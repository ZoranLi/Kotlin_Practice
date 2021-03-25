package com.example.myapplication.api

import com.example.myapplication.data.LoginResponse
import com.example.myapplication.data.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanAPI {
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(
        @Field("username") name: String,
        @Field("password") password: String
    ): Observable<LoginResponseWrapper<LoginResponse>>;

}