package com.example.p2_api_eval.ui.screens.PokemonList

import Pokemon
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p2_api_eval.data.repositories.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
*Viewmodel qui get les pokemon et les met dans un stateflow
 */
class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons

    init {
        viewModelScope.launch {
            repository.getPokemons().collect { list ->
                _pokemons.value = list
            }
        }
    }
}
