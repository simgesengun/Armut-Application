package com.simgesengun.armutapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simgesengun.armutapplication.entity.BlogPost
import com.simgesengun.armutapplication.entity.Service
import com.simgesengun.armutapplication.repo.GetDataCallback
import com.simgesengun.armutapplication.repo.ServiceDaoRepository

class HomepageViewModel : ViewModel() {

    var serviceList = MutableLiveData<List<Service>>()
    var popularServiceList = MutableLiveData<List<Service>>()
    var postList = MutableLiveData<List<BlogPost>>()
    private val sdaor = ServiceDaoRepository()

    init {
        loadServices()
        serviceList = sdaor.getServiceList()
        popularServiceList = sdaor.getPopularServiceList()
        postList = sdaor.getPostList()


    }

    fun loadServices(){
        sdaor.getAllServices()
    }

    fun getService(id : Int, dataCallback: GetDataCallback){
        sdaor.getService(id, dataCallback)
    }
}