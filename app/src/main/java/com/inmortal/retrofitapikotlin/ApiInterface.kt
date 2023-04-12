


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("getHotelList")
     fun  privacyPolicy(
        @Field("latitude") latitude: String,
        @Field("logitude") logitude:String): Call<JsonObject>

     @POST("GetMyTripList")
     fun getMyTripList():Call<JsonObject>

}

