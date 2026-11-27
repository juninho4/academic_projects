package com.example.geomath

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.geomath.ui.theme.GeoMathTheme

import com.example.geomath.navigation.GeoMathNavGraph

import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.geomath.ui.settings.SettingsViewModel


class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val darkModeEnabled by
            settingsViewModel.darkModeEnabled
                .collectAsStateWithLifecycle()

            GeoMathTheme(
                darkTheme = darkModeEnabled
            ) {
                GeoMathNavGraph()
            }
        }
    }
}