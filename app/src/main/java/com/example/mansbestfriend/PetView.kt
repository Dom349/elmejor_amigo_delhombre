package com.example.mansbestfriend

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun BreedScren(petViewModel: PetViewModel = viewModel()) {
    val amiibos by petViewModel.PetList.collectAsState()
    Column {
        Modifier
            .padding(15.dp)
        LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp), // Tamaño mínimo de cada celda
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
    { items(Breed) { breeds ->
            BreedItem(breed = breeds, nav)
        }
    }
}

}

@Composable
fun BreedItem(breed: Breed , nav: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Hacer que la altura sea igual al ancho
            .padding(8.dp)
            .clickable {
                nav.navigate("p4/${breed._id}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = breed.img,
                contentDescription = null,
            )
            Text(breed.name, color = androidx.compose.ui.graphics.Color.Red)
        }

    }

}

@Composable
fun BreedScreen(
    breedViewModel: PetViewModel = viewModel(),
    breed_id: String,
    nav: NavHostController
) {
    breedViewModel.getCharacter(breed_id)
    val breed by breedViewModel.breed.observeAsState()
    breed?.let {
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            AsyncImage(
                model = it.img,
                contentDescription = "",
                modifier = Modifier.clickable { nav.navigate("home") })
            Text(text = it.name)
        }
    }

}
