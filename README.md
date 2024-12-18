# Pokémon Application

## Overview

This is a Kotlin-based Android application built using Jetpack Compose for displaying and exploring Pokémon data. The app provides a list of Pokémon and detailed information about individual Pokémon.

## Features

- 🌓 Dark/Light Theme Toggle
- 🌍 Multilingual Support (French/English)
- 📱 Modern UI with Material Design 3
- 🔍 Pokémon List Screen
- 📊 Pokémon Detail Screen

## Technologies Used

- Kotlin
- Jetpack Compose
- Navigation Component
- ViewModel
- Coil for Image Loading

## Project Structure

```
com.example.p2_api_eval
│
├── ui
│   ├── navigation
│   │   └── AppNavGraph.kt        # App navigation logic
│   ├── screens
│   │   ├── PokemonList
│   │   │   ├── PokemonListScreen.kt
│   │   │   └── PokemonViewModel.kt
│   │   └── PokemonDetail
│   │       ├── PokemonDetailScreen.kt
│   │       └── PokemonDetailViewModel.kt
│   ├── components
│   │   └── PokemonCard.kt
│   └── theme
│       └── AppTheme.kt
│
└── MainActivity.kt
```

## Language Support

The application supports two languages:
- 🇫🇷 French (default)
- 🇬🇧 English

Language can be set in `MainActivity` or automatically detected from device settings.

## Theme Management

- Dark and Light themes are supported
- Theme can be toggled with a button in the app bar
- Default is set to Dark theme

## Installation

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on an Android device or emulator

## Configuration

To change the default language, modify the `language` parameter in `MainActivity`:

```kotlin
AppNavGraph(
    navController = navController, 
    onToggleTheme = { /* theme toggle logic */ },
    language = "fr"  // Change to "en" for English
)
```

## Dependencies

- AndroidX Compose
- Navigation Compose
- Coil
- ViewModel

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

[Your License Here]

## Contact

[Your Contact Information]
