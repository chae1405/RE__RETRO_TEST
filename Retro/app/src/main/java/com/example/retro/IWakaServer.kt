package com.example.retro


import com.example.retro.RetrofitClient.getInstance
import retrofit2.Call
import retrofit2.create
import retrofit2.http.*
import retrofit2.http.GET

interface IWakaServer {
    companion object {
        fun RetrofitClient(): IWakaServer? = getInstance()?.create(IWakaServer::class.java)
        fun create(): IWakaServer? {
            return getInstance()?.create()
        }
    }
    @POST("/user/")
    fun userlogin(@Body user : UserCreationElement):Call<List>
    }
  /*  @GET("https://dongagd.herokuapp.com/user/")
    fun getUserList(
        @Query("username") username:String,
        @Query("password") password:String,
        @Query("email") email:String,
        @Query("familyname") familyname:String,
        @Query("age")age:String,
        @Query("dateofbirth") dateofbirth:String
    ): Call<List>
*/
