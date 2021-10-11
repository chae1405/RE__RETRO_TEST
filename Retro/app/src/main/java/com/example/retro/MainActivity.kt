package com.example.retro

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val IWakaServer = com.example.retro.IWakaServer.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val userdata = "입력한 username 데이터"
        val passwoddata = "압력한 패스워드 데이터"
        val phonenumberdata = "입력한 phonenumber 데이터"
        val familynamedata = "입력한 이름 성 데이터"
        val agedata = "입력한 age 데이터"
        val dateofonesbirthdata = "입력한 생년월일 데이터"
        val ucelement = UserCreationElement(
            "입력한 username 데이터",
            "입력한 password 데이터",
            "입력한 phonenumber 데이 터",
            "입력한 email 데이터",
            "입력한 familyname 데이터",
            "입력한 age 데이터",
            "입력한 dateofonesbirth 데이터"
        )


        IWakaServer?.userlogin(ucelement)
            ?.enqueue(object : Callback<List>
            {
                    override fun onFailure (call: Call<List>,t:Throwable)
                    {

                        Log.d("tag:","error")
                    }

                override fun onResponse(call: Call<List>, response: Response<List>)
                {
                   if (response.isSuccessful)
                   {


                      Log.d("tag","결과:${response.code()}")


                   }else
                   {

                       Log.d("tag","${response.code().toString()}")
                       Log.e("tag","onFailure" + response.message())


                   }
                }

            })

    }
}