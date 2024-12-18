package com.example.p2_api_eval.data.repositories

import Pokemon
import com.example.p2_api_eval.data.datasources.mockPokemonData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

/*
*Permet de recuperer tout les pokemon ou juste un via l'id
 */
interface IPokemonRepository {
    fun getPokemons(): Flow<List<Pokemon>>
    fun getPokemonById(id: Int): Flow<Pokemon?>
}

class PokemonRepository : IPokemonRepository {
    private val pokemonFlow = MutableStateFlow(mockPokemonData)

    override fun getPokemons(): Flow<List<Pokemon>> = pokemonFlow.asStateFlow()

    override fun getPokemonById(id: Int): Flow<Pokemon?> {
        return pokemonFlow.map { list ->
            list.find { it.id == id }
        }
    }
}

