package com.example.amphibiansapp.data.Source

import com.example.amphibiansapp.data.Model.Amphibian
import retrofit2.http.GET

interface AmphibianDataSource {

    @GET("amphibians")
    suspend fun getAmphibian():List<Amphibian>


}