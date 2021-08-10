package com.simgesengun.armutapplication.retrofit

import com.simgesengun.armutapplication.entity.ResponseBody
import com.simgesengun.armutapplication.entity.Service
import com.simgesengun.armutapplication.entity.ServiceDetail
import retrofit2.Call
import retrofit2.http.*

interface ServiceDao {
    @GET("home")
    fun getAllServices() : Call<ResponseBody>

    @GET("service/{id}")
    fun getService(@Path("id") id: Int): Call<ServiceDetail>
}
