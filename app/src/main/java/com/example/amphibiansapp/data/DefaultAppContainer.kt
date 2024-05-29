package com.example.amphibiansapp.data

import com.example.amphibiansapp.data.Source.AmphibianDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
interface AppContainer {
    val repository :AmpRepository
}
class DefaultAppContainer:AppContainer {

    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"


    private val retrofit:Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()



    private val retrofitSerivce: AmphibianDataSource by lazy {
        retrofit.create(AmphibianDataSource::class.java)
    }

    override val repository: AmpRepository by lazy {
        NetworkRequestAmphibian(retrofitSerivce)
    }


}