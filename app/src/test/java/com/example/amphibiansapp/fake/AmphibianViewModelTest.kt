package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.Model.Amphibian
import com.example.amphibiansapp.ui.theme.screens.AmpViewModel
import com.example.amphibiansapp.ui.theme.screens.AmphibianUiState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AmphibianViewModelTest {


    @Test
    fun testGetAmphibian(){
        runTest {

            val ampViewModel = AmpViewModel(
                repository=FakeNetworkPhotosRepository()
            )
            assertEquals(AmphibianUiState.Success(FakeDataSource.amphibianList),ampViewModel.amphibianUiState)



        }
    }
}