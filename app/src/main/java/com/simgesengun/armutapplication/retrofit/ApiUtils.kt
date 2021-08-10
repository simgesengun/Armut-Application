package com.simgesengun.armutapplication.retrofit

import com.simgesengun.armutapplication.retrofit.RetrofitClient.Companion.getClient
import com.simgesengun.armutapplication.retrofit.ServiceDao

class ApiUtils {
    companion object{
        val BASE_URL : String = "https://my-json-server.typicode.com/engincancan/case/"

        fun getServiceDao() : ServiceDao {
            return getClient(BASE_URL).create(ServiceDao::class.java)
        }
    }
}