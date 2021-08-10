package com.simgesengun.armutapplication

import com.simgesengun.armutapplication.entity.ServiceDetail
import com.simgesengun.armutapplication.retrofit.ApiUtils
import com.simgesengun.armutapplication.retrofit.ServiceDao
import junit.framework.TestCase.assertNotNull
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitTest{
    private lateinit var sdaoi: ServiceDao

    @Before
    fun setUp() {
        sdaoi = ApiUtils.getServiceDao()
    }

    @Test
    fun `get all services response successfull` () {
        val response = sdaoi.getAllServices().execute()
        assertThat(response.code(),equalTo(200))
    }

    @Test
    fun `can get all services` () {
        val response = sdaoi.getAllServices().execute()
        assertNotNull(response.body())
    }


    @Test
    fun `can get service detail` () {
        val response = sdaoi.getService(191).execute()
        assertNotNull(response.body())
    }

}