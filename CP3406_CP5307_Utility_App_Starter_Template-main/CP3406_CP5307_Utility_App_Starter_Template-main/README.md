# Currency Converter App – CP3406 / CP5307

This is a basic Android app template for **Assessment 1: Utility App** in CP3406/CP5603..  
It provides the structure for a simple tabular UI using **Jetpack Compose** and **Material Design 3**.

---

## Getting Started

### How to Run
1. Clone or download this repo  
2. Open the project in Android Studio
3. Add your API key in `RetroFitInstance.kt` (if required) 
4. Run the app on an emulator or physical device (API 26+ recommended)  

---

## App Features

### Utility Screen (Currency Converter)
- Convert between multiple currencies using live exchange rates
- Input amount using a text field
- Select base and target currencies
- Displays the converted result instantly
- Fetches real-time exchange rates using a REST API

### Settings Screen
- Placeholder for user preferences
- Can be extended to include:
  - Default currency selection
  - Decimal precision settings
  - Theme configuration

---

## Key Architecture Components

| Layer | Description |
|------|-------------|
| UI (Jetpack Compose) | Displays screens and handles user interaction |
| ViewModel | Manages UI state and business logic |
| Repository | Handles data operations and API calls |
| Retrofit | Fetches live currency exchange rates from API |
| Coroutines | Handles asynchronous network requests |

---

## API Used

This project uses the **ExchangeRate API** for live currency conversion data.

https://www.exchangerate-api.com/

Example endpoint:

---

## Technologies Used
- Kotlin
- Jetpack Compose
- Material Design 3
- Retrofit
- Gson Converter
- Coroutines
- ViewModel (Android Architecture Components)

---

## Key Concepts Covered

| Week | Concept                        | Used In                          |
|------|--------------------------------|----------------------------------|
| 1    | Kotlin + Android Studio         | MainActivity.kt |
| 2    | Jetpack Compose Layouts         | UtilityApp(), UtilityScreen(), SettingsScreen()   |
| 3    | Material Design 3               | CP3406_CP5603UtilityAppStarterTemplateTheme, MaterialTheme.typography |
| 4    | ViewModel + Repository Pattern  | CurrencyViewModel + CurrencyRepository |
| 5    | Retrofit API Integration        | Currency API service + networking |

---

## Suggested Extensions
- Replace counter with a real utility
- Add a ViewModel for state management  
- Use SharedPreferences or DataStore to persist settings  
- Add a simple API call using Retrofit

---

## 📚 License
This project is for educational purposes as part of CP3406/CP5603 assessment submission
