# Application Pokémon

## Vue d'ensemble

Il s'agit d'une application Android développée avec Kotlin et Jetpack Compose, permettant d'afficher et d'explorer les données des Pokémons.
L'application propose une liste des Pokémons ainsi que des informations détaillées sur chacun d'entre eux.

## Fonctionnalités

- 🌓 Basculement entre thème Clair/Sombre
- 🌍 Prise en charge de plusieurs langues (Français/Anglais)
- 📱 Vibration et effet sonore
- 🔍 Écran de liste des Pokémons
- 📊 Écran de détails d'un Pokémon

## Technologies utilisées

- Kotlin
- Jetpack Compose
- Navigation Component
- ViewModel
- Coil pour le chargement d'images

##  Api séléctioné

Lien de l'api utilisé pour crée les données Mock :
https://pokebuildapi.fr/api/v1

## Structure du projet

```
com.example.p2_api_eval
│
├── data
│   ├── datasources
│   │   └── MockPokemon.kt
│   └── repositories
│       └── PokemonRepository.kt
│
├── domain
│   ├── models
│   │   └── Pokemon.kt
│   └── repositories
│
├── ui
│   ├── composable
│   │   └── PokemonCard.kt
│   ├── navigation
│   │   └── AppNavGraph.kt
│   ├── screens
│   │   ├── PokemonList
│   │   │   ├── PokemonListScreen.kt
│   │   │   └── PokemonListViewModel.kt
│   │   └── PokemonDetail
│   │       ├── PokemonDetailScreen.kt
│   │       └── PokemonDetailViewModel.kt
│   └── theme
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
│
├── utils
├── MainActivity.kt
└── res
    ├── drawable
    ├── mipmap
    ├── raw
    │   └── bip_sound.mp3
    └── values
        ├── colors.xml
        ├── strings.xml
        └── themes.xml
```

## Prise en charge des langues

L'application prend en charge deux langues :
- 🇫🇷 Français (par défaut)
- 🇬🇧 Anglais

La langue peut être définie dans `MainActivity` ou détectée automatiquement à partir des paramètres de l'appareil.

## Gestion des thèmes

- Les thèmes Clair et Sombre sont pris en charge
- Le thème peut être basculé à l'aide d'un bouton dans la barre d'application
- Le thème par défaut est le thème Sombre

## Configuration

Pour modifier la langue par défaut, modifiez le paramètre `language` dans `MainActivity` :

```kotlin
AppNavGraph(
    navController = navController, 
    onToggleTheme = { /* logique de basculement du thème */ },
    language = "fr"  // Modifiez en "en" pour l'anglais
)
```

## 🚀 Installation

Suivez ces étapes pour exécuter l'application localement :

1. Clonez ce dépôt :
   ```bash
   git clone https://github.com/votre-repo/pokemon-explorer.git
   ```
   
2. Ouvrez le projet dans Android Studio.

3. Synchronisez les fichiers Gradle.

4. Lancez l'application sur un émulateur ou un appareil Android réel.

🎉 Merci d'utiliser Pokémon Explorer ! Amusez-vous bien avec vos Pokémon ! 🚀





