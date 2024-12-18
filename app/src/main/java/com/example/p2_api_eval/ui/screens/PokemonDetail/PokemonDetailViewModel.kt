package com.example.p2_api_eval.ui.screens.PokemonDetail

import Pokemon
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p2_api_eval.data.repositories.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
*Viewmodel qui get le pokemon lie a l'id et les met dans un stateflow
 */
class PokemonDetailViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon: StateFlow<Pokemon?> = _pokemon


    fun loadPokemonById(pokemonId: Int) {
        viewModelScope.launch {
            repository.getPokemonById(pokemonId).collect { pkmn ->
                _pokemon.value = pkmn
            }
        }
    }
}
