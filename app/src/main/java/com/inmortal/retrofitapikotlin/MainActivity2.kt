package com.inmortal.retrofitapikotlin

import RetrofitClient
import android.content.Context
import android.os.Bundle
import android.text.PrecomputedText.Params
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var context:Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        PostApiAboutTrip()
//        getMyTripLIst()
//        getMyTripListVolley()
    }

    private fun PostApiAboutTrip() {


        val call: Call<JsonObject>? =
            RetrofitClient.instance?.api?.privacyPolicy("28.61298929", "77.37764774")
        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>, response: Response<JsonObject?>
            ) {
                Log.d("dsfdsf", response.body().toString())
                Toast.makeText(this@MainActivity2, ""+response.body().toString(), Toast.LENGTH_LONG).show()

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
    private fun getMyTripListVolley(){
        val url="https://inmortaltech.com/Urplan/getHotelList"
      val requestQue: RequestQueue=Volley.newRequestQueue(this)
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST,url ,
            com.android.volley.Response.Listener { response ->


                    val jsonObject = JSONObject(response)
                Toast.makeText(this,""+response,Toast.LENGTH_SHORT).show()
                    val status = jsonObject.getString("status")
                    if (status == "true") {
                        val jsonArray = jsonObject.getJSONArray("data")
                        for (i in 0 until jsonArray.length()) {
                            val `object` = jsonArray.getJSONObject(i)
                            val name = `object`.getString("name")
                            val address = `object`.getString("address")
                            val ratings = `object`.getString("rating")
                            Log.d("ffddg", name)

                        }
                    }

            },
            com.android.volley.Response.ErrorListener {


            }
        ) {
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["latitude"] = "28.61298929"
                params["logitude"] = "77.37764774"
                return params
            }
        }
        requestQue.add(stringRequest)



    }

}