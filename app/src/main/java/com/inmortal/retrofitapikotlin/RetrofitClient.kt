
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient  {
    init { //constructor
        retrofit =
            Retrofit.Builder().baseUrl(base_url2).addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

    companion object {
        private const val base_url2 = "https://inmortaltech.com/Urplan/"
        private var retrofitClient: RetrofitClient? = null
        private lateinit var retrofit: Retrofit


        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }
}