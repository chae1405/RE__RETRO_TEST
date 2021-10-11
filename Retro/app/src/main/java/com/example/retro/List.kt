package com.example.retro

import com.google.gson.annotations.SerializedName

class List(
    @SerializedName("age")
    var age : String,
    @SerializedName("email")
    var email: String,
    @SerializedName("familyname")
    var familyname:String,
    @SerializedName("password")
    var username:String

)