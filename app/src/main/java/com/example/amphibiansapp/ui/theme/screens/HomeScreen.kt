package com.example.amphibiansapp.ui.theme.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.data.Model.Amphibian

@Composable
fun AmpPhotoApp(amphibianUiState: AmphibianUiState, modifier: Modifier=Modifier, contentPadding: PaddingValues = PaddingValues(0.dp),) {

    when (amphibianUiState){
        is AmphibianUiState.Loading -> LoadingScreen()
        is AmphibianUiState.Error -> ErrorScreen()
        is AmphibianUiState.Success -> AmphibianHorizontalColumn(amphibian = amphibianUiState.amphibians)
    }

}


@Composable
fun AmphibianHorizontalColumn(amphibian: List<Amphibian>) {


    LazyColumn(modifier = Modifier.padding(top=90.dp, bottom = 70.dp), ) {


        items(amphibian){ amphibian->
            AmphibianPhotoCard(amphibian)



        }



    }

}


@Composable
fun LoadingScreen() {
    Image(
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = "Loading Images ",
        modifier = Modifier.size(100.dp)
    )


}

@Preview
@Composable
fun LoadingScreenPreview() {

    LoadingScreen()


}


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = stringResource(
                id = R.string.error
            )
        )
        Text(text = "Error in Loading data from internet ")


    }


}


@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen()
}

@Composable
fun AmphibianPhotoCard(amphibian: Amphibian,modifier: Modifier = Modifier) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        modifier = modifier.padding(10.dp)


    ) {
        Column {


            Spacer(modifier = Modifier.padding(5.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = amphibian.name,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
            Column {

            }

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(amphibian.photo)
                    .crossfade(true).build(),
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),


                contentDescription = "Image of Amphibian "
            )
            Column {
                Text(
                    text = amphibian.description,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding( 10.dp)
                )

            }


        }

    }


}


//@Preview
//@Composable
//fun MarsPhotoPreview() {
//
//    AmphibianPhotoCard()
//
//
//}