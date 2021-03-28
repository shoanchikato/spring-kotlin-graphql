package com.sample.springkotlingraphql.retrofit.todos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TodoDto(

        @SerializedName("userId")
        @Expose
        val userId: Int,

        @SerializedName("title")
        @Expose
        val title: String,

        @SerializedName("completed")
        @Expose
        val completed: Boolean,

)