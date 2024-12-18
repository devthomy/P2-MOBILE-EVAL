package com.example.p2_api_eval.ui.screens.PokemonDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.p2_api_eval.R
import java.util.Locale

/**
 * @param pokemonId id du pokemon
 * @param navController gere la navigation
 * @param onToggleTheme gere le theme
 * affiche les details lie au pokemon selectionner via son id
 */@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemonId: Int,
    navController: NavController,
    onToggleTheme: () -> Unit,
    language: String = Locale.getDefault().language
) {
    val viewModel: PokemonDetailViewModel = viewModel()

    LaunchedEffect(pokemonId) {
        viewModel.loadPokemonById(pokemonId)
    }

    val pokemon = viewModel.pokemon.collectAsState().value

    // Localized strings
    val pokemonDetailsTitle = when (language) {
        "fr" -> R.string.pokemon_details_title_fr
        else -> R.string.pokemon_details_title_en
    }

    val noPokemonFoundText = when (language) {
        "fr" -> R.string.no_pokemon_found_fr
        else -> R.string.no_pokemon_found_en
    }

    val themeChangeDescription = when (language) {
        "fr" -> R.string.change_theme_fr
        else -> R.string.change_theme_en
    }

    val backDescription = when (language) {
        "fr" -> R.string.back_fr
        else -> R.string.back_en
    }

    val basicInfoTitle = when (language) {
        "fr" -> R.string.basic_info_title_fr
        else -> R.string.basic_info_title_en
    }

    val statsTitle = when (language) {
        "fr" -> R.string.stats_title_fr
        else -> R.string.stats_title_en
    }

    val resistancesTitle = when (language) {
        "fr" -> R.string.resistances_title_fr
        else -> R.string.resistances_title_en
    }

    val evolutionsTitle = when (language) {
        "fr" -> R.string.evolutions_title_fr
        else -> R.string.evolutions_title_en
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = pokemon?.name ?: stringResource(id = pokemonDetailsTitle),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    IconButton(onClick = { onToggleTheme() }) {
                        Icon(
                            imageVector = Icons.Default.Brightness4,
                            contentDescription = stringResource(id = themeChangeDescription)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = backDescription)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (pokemon == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(id = noPokemonFoundText, pokemonId))
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                item {
                    // Pokemon Image
                    //Image(
                    //    painter = rememberAsyncImagePainter(model = pokemon.image),
                    //    contentDescription = "${pokemon.name} image",
                    //    modifier = Modifier
                    //        .fillMaxWidth()
                    //        .height(200.dp),
                    //    contentScale = ContentScale.Fit
                    //)

                    //AsyncImage(
                    //    model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                    //    contentDescription = null,
                    //    modifier = Modifier.size(200.dp)
                    //)


                    Text(
                        text = pokemon.name,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = basicInfoTitle),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text("ID: ${pokemon.id}", style = MaterialTheme.typography.bodyMedium)
                    Text("Pokedex ID: ${pokemon.pokedexId}", style = MaterialTheme.typography.bodyMedium)
                    Text("Type(s): ${pokemon.types.joinToString { it.name }}", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = statsTitle),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text("HP: ${pokemon.stats.hp}", style = MaterialTheme.typography.bodyMedium)
                    Text("Attaque: ${pokemon.stats.attack}", style = MaterialTheme.typography.bodyMedium)
                    Text("Défense: ${pokemon.stats.defense}", style = MaterialTheme.typography.bodyMedium)
                    Text("Attaque Spéciale: ${pokemon.stats.specialAttack}", style = MaterialTheme.typography.bodyMedium)
                    Text("Défense Spéciale: ${pokemon.stats.specialDefense}", style = MaterialTheme.typography.bodyMedium)
                    Text("Vitesse: ${pokemon.stats.speed}", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = resistancesTitle),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                items(pokemon.resistances) { resistance ->
                    Text(
                        text = "${resistance.name}: ${resistance.damageRelation} (x${resistance.damageMultiplier})",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }

                if (pokemon.evolutions.isNotEmpty()) {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = evolutionsTitle),
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    items(pokemon.evolutions) { evolution ->
                        Text(
                            text = "${evolution.name} (Pokedex ID: ${evolution.pokedexId})",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}