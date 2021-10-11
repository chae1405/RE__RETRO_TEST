package com.example.retro

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

        val username = findViewById<EditText>(R.id.username)
        val password =findViewById<EditText>(R.id.password)
        val phonenumber = findViewById<EditText>(R.id.phonenumber)
        val familyname = findViewById<EditText>(R.id.familyname)
        val age = findViewById<EditText>(R.id.age)
        val dateofonesbirth = findViewById<EditText>(R.id.dateofonesbirth)
        val email = findViewById<EditText>(R.id.email)



        button.setOnClickListener {

            var email = email.text.toString()
            var birth = dateofonesbirth.text.toString()
            var userid = username.text.toString()
            var pass = password.text.toString()
            var age = age.text.toString()
            var number = phonenumber.text.toString()
            var familyname = familyname.text.toString()

            val ucelement = UserCreationElement(
                userid,pass,number,email,familyname,age,birth
            )




            IWakaServer?.userlogin(ucelement)
                ?.enqueue(object : Callback<List>
                {
                    override fun onFailure (call: Call<List>, t:Throwable)
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
}