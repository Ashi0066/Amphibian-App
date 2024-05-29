package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.Model.Amphibian
import com.example.amphibiansapp.data.Source.AmphibianDataSource

class FakeAmphibianApiService :AmphibianDataSource{
    override suspend fun getAmphibian(): List<Amphibian> {
        return FakeDataSource.amphibianList
    }


}