/*
*Class pour un pokemon
 */
data class Pokemon(
    val id: Int,
    val pokedexId: Int,
    val name: String,
    val image: String,
    val sprite: String,
    val slug: String,
    val stats: Stats,
    val types: List<PokemonType>,
    val generation: Int,
    val resistances: List<Resistance>,
    val evolutions: List<Evolution>,
    val preEvolution: PreEvolution?
)

data class Stats(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int
)

data class PokemonType(
    val name: String,
    val image: String
)

data class Resistance(
    val name: String,
    val damageMultiplier: Double,
    val damageRelation: String
)

data class Evolution(
    val name: String,
    val pokedexId: Int
)

data class PreEvolution(
    val name: String,
    val pokedexId: Int
)

