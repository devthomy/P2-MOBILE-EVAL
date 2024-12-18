package com.example.p2_api_eval.data.datasources

import Evolution
import Pokemon
import PokemonType
import Resistance
import Stats

/*
*Faux pokemon
 */
val mockPokemonData = listOf(
    Pokemon(
        id = 1,
        pokedexId = 1,
        name = "Bulbizarre",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        slug = "bulbizarre",
        stats = Stats(
            hp = 45,
            attack = 49,
            defense = 49,
            specialAttack = 65,
            specialDefense = 65,
            speed = 45
        ),
        types = listOf(
            PokemonType("Plante", "https://static.wikia.nocookie.net/pokemongo/images/c/c5/Grass.png"),
            PokemonType("Poison", "https://static.wikia.nocookie.net/pokemongo/images/0/05/Poison.png")
        ),
        generation = 1,
        resistances = listOf(
            Resistance("Normal", 1.0, "neutre"),
            Resistance("Combat", 0.5, "résistant"),
            Resistance("Vol", 2.0, "vulnérable")
        ),
        evolutions = listOf(
            Evolution("Herbizarre", 2)
        ),
        preEvolution = null
    ),
    Pokemon(
        id = 2,
        pokedexId = 4,
        name = "Salamèche",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
        slug = "salameche",
        stats = Stats(
            hp = 39,
            attack = 52,
            defense = 43,
            specialAttack = 60,
            specialDefense = 50,
            speed = 65
        ),
        types = listOf(
            PokemonType("Feu", "https://static.wikia.nocookie.net/pokemongo/images/4/4a/Fire.png")
        ),
        generation = 1,
        resistances = listOf(
            Resistance("Normal", 1.0, "neutre"),
            Resistance("Feu", 0.5, "résistant"),
            Resistance("Eau", 2.0, "vulnérable")
        ),
        evolutions = listOf(
            Evolution("Reptincel", 5)
        ),
        preEvolution = null
    ),
    Pokemon(
        id = 3,
        pokedexId = 7,
        name = "Carapuce",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
        slug = "carapuce",
        stats = Stats(
            hp = 44,
            attack = 48,
            defense = 65,
            specialAttack = 50,
            specialDefense = 64,
            speed = 43
        ),
        types = listOf(
            PokemonType("Eau", "https://static.wikia.nocookie.net/pokemongo/images/6/6f/Water.png")
        ),
        generation = 1,
        resistances = listOf(
            Resistance("Normal", 1.0, "neutre"),
            Resistance("Électrik", 2.0, "vulnérable"),
            Resistance("Eau", 0.5, "résistant")
        ),
        evolutions = listOf(
            Evolution("Carabaffe", 8)
        ),
        preEvolution = null
    ),
    Pokemon(
        id = 4,
        pokedexId = 25,
        name = "Pikachu",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
        slug = "pikachu",
        stats = Stats(
            hp = 35,
            attack = 55,
            defense = 40,
            specialAttack = 50,
            specialDefense = 50,
            speed = 90
        ),
        types = listOf(
            PokemonType("Électrik", "https://static.wikia.nocookie.net/pokemongo/images/1/1b/Electric.png")
        ),
        generation = 1,
        resistances = listOf(
            Resistance("Normal", 1.0, "neutre"),
            Resistance("Sol", 2.0, "vulnérable"),
            Resistance("Électrik", 0.5, "résistant")
        ),
        evolutions = listOf(
            Evolution("Raichu", 26)
        ),
        preEvolution = null
    )
)
