package com.simgesengun.armutapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Service (@SerializedName("id")
                   @Expose
                   var id : Int,
                   @SerializedName("service_id")
                   @Expose
                   var service_id : Int,
                   @SerializedName("name")
                   @Expose
                   var name : String,
                    @SerializedName("long_name")
                    @Expose
                    var long_name : String,
                    @SerializedName("image_url")
                    @Expose
                    var image_url : String,
                    @SerializedName("pro_count")
                    @Expose
                    var pro_count : Int) {
}