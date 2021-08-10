package com.simgesengun.armutapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BlogPost (@SerializedName("title")
                    @Expose
                    var title : String,
                     @SerializedName("category")
                    @Expose
                    var category : String,
                     @SerializedName("image_url")
                    @Expose
                    var image_url : String,
                     @SerializedName("link")
                    @Expose
                    var link : String) {
}