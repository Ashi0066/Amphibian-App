package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.AmpRepository
import com.example.amphibiansapp.data.Model.Amphibian

class FakeNetworkPhotosRepository:AmpRepository {
    override suspend fun getAmphibian(): List<Amphibian> {
        return FakeDataSource.amphibianList
    }
}