# GeoMath

GeoMath is an Android educational application designed to help students learn and practise geometry through interactive quizzes.

## Features

* Interactive geometry quizzes
* Multiple topics and difficulty levels
* Instant answer feedback and explanations
* Quiz score and progress tracking
* Statistics and previous quiz results
* Dark mode
* Sound effects
* Customisable settings
* Local data storage
* Geometry information from an external API

## Geometry Topics

The quiz currently covers:

* Angles
* Triangles
* Quadrilaterals
* Area & Perimeter
* Circles
* Volume

## Technologies

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **Room Database**
* **DataStore Preferences**
* **Retrofit**
* **Kotlin Coroutines**
* **JUnit**
* **KSP**

## Architecture

The application uses a layered structure with:

* UI screens built with Jetpack Compose
* ViewModels for application and screen state
* Domain logic for quiz processing
* Room for local quiz-result storage
* DataStore for user settings
* Retrofit for external API communication

## Getting Started

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync the Gradle project.
4. Connect an Android device or start an emulator.
5. Run the `app` configuration.

An Internet connection is required for the external geometry information feature.

## Purpose

GeoMath was developed as part of **CP3406 / CP5307 – Mobile Application Development** at James Cook University Singapore. The project demonstrates Android application development, local data persistence, API integration, user settings, and automated testing.
