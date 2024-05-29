package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.AmpRepository
import com.example.amphibiansapp.data.NetworkRequestAmphibian
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RepositoryTest {

    @Test
    fun networkCallTest(){
        runTest{
            val ampRepository = NetworkRequestAmphibian(
                FakeAmphibianApiService()
            )
            assertEquals(FakeDataSource.amphibianList, ampRepository.getAmphibian())
        }



    }




}