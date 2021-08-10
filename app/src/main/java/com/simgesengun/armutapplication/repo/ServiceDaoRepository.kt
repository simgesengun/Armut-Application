package com.simgesengun.armutapplication.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.simgesengun.armutapplication.entity.BlogPost
import com.simgesengun.armutapplication.entity.ResponseBody
import com.simgesengun.armutapplication.entity.Service
import com.simgesengun.armutapplication.entity.ServiceDetail
import com.simgesengun.armutapplication.retrofit.ApiUtils
import com.simgesengun.armutapplication.retrofit.ServiceDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceDaoRepository {
    private val sdaoi : ServiceDao
    private val serviceList : MutableLiveData<List<Service>>
    private val popularServiceList : MutableLiveData<List<Service>>
    private val postList : MutableLiveData<List<BlogPost>>

    init{
        sdaoi = ApiUtils.getServiceDao()
        serviceList = MutableLiveData()
        popularServiceList = MutableLiveData()
        postList = MutableLiveData()
    }

    fun getPopularServiceList() : MutableLiveData<List<Service>> {
        return popularServiceList
    }

    fun getServiceList() : MutableLiveData<List<Service>> {
        return serviceList
    }

    fun getPostList() : MutableLiveData<List<BlogPost>> {
        return postList
    }

    fun getAllServices() {
        sdaoi.getAllServices().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>) {
                val services = response.body()?.all_services
                val popularServices = response.body()?.popular_services
                val posts = response.body()?.posts

                serviceList.value = services
                popularServiceList.value = popularServices
                postList.value = posts

            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                Log.e("failure", t.toString())
            }
        })
    }


    fun getService(id: Int, getDataCallback: GetDataCallback){
        sdaoi.getService(id).enqueue(object : Callback<ServiceDetail> {
            override fun onResponse(call: Call<ServiceDetail>?, response: Response<ServiceDetail>) {
                if (response.isSuccessful) {
                    getDataCallback.onGetServiceDetail(response.body())
                } else {
                    getDataCallback.onError()
                }
            }

            override fun onFailure(call: Call<ServiceDetail>?, t: Throwable?) {
                Log.e("failure", t.toString())
            }
        })
    }
}

interface GetDataCallback {
    fun onGetServiceDetail(serviceDetail: ServiceDetail?)
    fun onError()
}
