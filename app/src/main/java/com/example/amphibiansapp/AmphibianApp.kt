@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.amphibiansapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ui.theme.screens.AmpPhotoApp
import com.example.amphibiansapp.ui.theme.screens.AmpViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AmphibianApp() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(
            scrollBehavior = scrollBehavior
        )
    }) {
        Surface(modifier = Modifier.fillMaxSize()) 
        {
            
            val ampViewModel:AmpViewModel =
                viewModel(factory = AmpViewModel.Factory)


            AmpPhotoApp(amphibianUiState = ampViewModel.amphibianUiState)

        }


    }


}


@Composable
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(scrollBehavior = scrollBehavior,
        title = { Text(text = "Amphibian App", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold, modifier = modifier.fillMaxWidth().padding(start = 10.dp)) })


}