package com.example.amphibiansapp.data

import com.example.amphibiansapp.data.Model.Amphibian
import com.example.amphibiansapp.data.Source.AmphibianDataSource


interface AmpRepository {
    suspend fun getAmphibian(): List<Amphibian>
}


class NetworkRequestAmphibian(
    private val ampApiService: AmphibianDataSource
) : AmpRepository {

    override suspend fun getAmphibian(): List<Amphibian> = ampApiService.getAmphibian()


}