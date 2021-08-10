package com.simgesengun.armutapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simgesengun.armutapplication.entity.Service
import com.simgesengun.armutapplication.entity.BlogPost

data class ResponseBody(@SerializedName("all_services")
                          @Expose
                          var all_services : List<Service>,
                          @SerializedName("popular")
                          @Expose
                          var popular_services : List<Service>,
                        @SerializedName("posts")
                        @Expose
                        var posts : List<BlogPost>) {
}