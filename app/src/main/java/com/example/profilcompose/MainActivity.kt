package com.example.profilcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.profilcompose.ui.theme.ProfilComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "Alex Martin",
                        role = "Développeur Android junior",
                        description = "Étudiant en informatique passionné par le mobile. " +
                            "J'aime concevoir des interfaces claires avec Jetpack Compose.",
                        skills = listOf("Kotlin", "Jetpack Compose", "Git", "Material 3"),
                        contact = "alex.martin@example.com",
                        isAvailable = true,
                        onContactClick = { onContactClicked() },
                        onAvailabilityClick = { onAvailabilityClicked() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun onContactClicked() {
        // TODO : ouvrir l'application mail
    }

    private fun onAvailabilityClicked() {
        // TODO : afficher le détail de la disponibilité
    }
}
