package com.example.amphibiansapp.ui.theme.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibianApplication
import com.example.amphibiansapp.data.AmpRepository
import com.example.amphibiansapp.data.Model.Amphibian
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState


}

class AmpViewModel(private val repository: AmpRepository) : ViewModel() {


    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set


    init {
        getAmphibian()
    }

    fun getAmphibian() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                AmphibianUiState.Success(
                    repository.getAmphibian()
                )
            } catch (e: IOException) {
                AmphibianUiState.Error
            } catch (e: HttpException) {
                AmphibianUiState.Error
            }


        }


    }

    companion object{
        val Factory : ViewModelProvider.Factory= viewModelFactory {
            initializer{
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val ampRepository = application.appContainer.repository
             AmpViewModel(ampRepository)

            }
        }
    }


}