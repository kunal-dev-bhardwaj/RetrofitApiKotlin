package com.inmortal.retrofitapikotlin

import RetrofitClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        PostApiAboutTrip()
        getMyTripLIst()
    }

    private  fun PostApiAboutTrip(){


        val call: Call<JsonObject>? = RetrofitClient.instance?.api?.privacyPolicy("28.61298929","77.37764774")
        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>, response: Response<JsonObject?>
            ) {
                Log.d("dsfdsf",response.body().toString())

//                binding.pbPriPol.setVisibility(View.GONE)
//                val policyModel: JsonObject? = response.body()
//                val success: String = policyModel.getSuccess().toString()
//                if (success == "true") {
//                    val data: String = policyModel.getData()
//                    binding.tvPriPol.setText(Html.fromHtml(data))
//                } else {
//                    Toast.makeText(
//                        this@PrivacyPolicyActivity,
//                        "something went wrong",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                Toast.makeText(this@PrivacyPolicyActivity, "" + t.message, Toast.LENGTH_SHORT)
//                    .show()
            }
        })

    }
    private  fun getMyTripLIst(){
        val call:Call<JsonObject>? =RetrofitClient.instance?.api?.getMyTripList()
        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>, response: Response<JsonObject?>
            ) {
                Log.d("llllljmjj",response.body().toString())

//                binding.pbPriPol.setVisibility(View.GONE)
//                val policyModel: JsonObject? = response.body()
//                val success: String = policyModel.getSuccess().toString()
//                if (success == "true") {
//                    val data: String = policyModel.getData()
//                    binding.tvPriPol.setText(Html.fromHtml(data))
//                } else {
//                    Toast.makeText(
//                        this@PrivacyPolicyActivity,
//                        "something went wrong",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                Toast.makeText(this@PrivacyPolicyActivity, "" + t.message, Toast.LENGTH_SHORT)
//                    .show()
            }
        })

    }


}