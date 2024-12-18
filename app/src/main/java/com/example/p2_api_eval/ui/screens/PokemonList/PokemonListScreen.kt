package com.example.p2_api_eval.ui.screens.PokemonList

import android.media.MediaPlayer
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.p2_api_eval.R
import com.example.p2_api_eval.ui.components.PokemonCard
import java.util.Locale


/**
 * @param navController gere la navigation
 * @param onToggleTheme gere le theme
 * affiche la liste de tout les pokemon du Mock
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    navController: NavController = rememberNavController(),
    onToggleTheme: () -> Unit,
    language: String = Locale.getDefault().language
) {
    val viewModel: PokemonViewModel = viewModel()
    val pokemons = viewModel.pokemons.collectAsState()
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current

   val screenTitle = when (language) {
        "fr" -> R.string.basic_info_title_fr
        else -> R.string.basic_info_title_en
    }

    val noPokemonText = when (language) {
        "fr" -> R.string.no_pokemon_found_fr
        else -> R.string.no_pokemon_found_en
    }

    val themeChangeDescription = when (language) {
        "fr" -> R.string.change_theme_fr
        else -> R.string.change_theme_en
    }

    val bipSound = remember(context) {
        try {
            MediaPlayer.create(context, R.raw.bip_sound)
        } catch (e: Exception) {
            null
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = screenTitle),
                        fontSize = 20.sp
                    )
                },
                actions = {
                    IconButton(onClick = { onToggleTheme() }) {
                        Icon(
                            imageVector = Icons.Default.BrightnessMedium,
                            contentDescription = stringResource(id = themeChangeDescription)
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            if (pokemons.value.isEmpty()) {
                Text(
                    text = stringResource(id = noPokemonText),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 16.sp
                )
            } else {
                LazyColumn {
                    items(pokemons.value) { pokemon ->
                        PokemonCard(
                            pokemon = pokemon,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clickable {
                                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)

                                    bipSound?.let { player ->
                                        if (!player.isPlaying) {
                                            player.start()
                                        }
                                    }

                                    navController.navigate("pokemonDetail/${pokemon.id}")
                                }
                        )
                    }
                }
            }
        }
    }

    DisposableEffect(bipSound) {
        onDispose {
            bipSound?.release()
        }
    }
}