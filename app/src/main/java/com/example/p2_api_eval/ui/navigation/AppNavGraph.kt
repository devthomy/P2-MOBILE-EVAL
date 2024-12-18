package com.example.p2_api_eval.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.p2_api_eval.ui.screens.PokemonDetail.PokemonDetailScreen
import com.example.p2_api_eval.ui.screens.PokemonList.PokemonListScreen
import java.util.Locale

/*
*Navigation de l'application entre les deux screen
 */
@Composable
fun AppNavGraph(
    navController: NavHostController,
    onToggleTheme: () -> Unit,
    language: String = Locale.getDefault().language
) {
    NavHost(navController, startDestination = "pokemonlist") {
        composable("pokemonlist") {
            PokemonListScreen(
                navController = navController,
                onToggleTheme = onToggleTheme,
                language = language
            )
        }
        composable("pokemonDetail/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toInt()
            if (pokemonId != null) {
                PokemonDetailScreen(
                    pokemonId = pokemonId,
                    navController = navController,
                    onToggleTheme = onToggleTheme,
                    language = language
                )
            }
        }
    }
}