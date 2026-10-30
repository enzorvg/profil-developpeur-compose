package com.example.profilcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilcompose.ui.theme.ProfilComposeTheme

// Écran principal de la fiche profil
@Composable
fun ProfileScreen(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    isAvailable: Boolean,
    onContactClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        ProfileHeader(
            name = name,
            role = role,
            // padding externe
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        ProfileDescription(
            description = description,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        SkillList(
            skills = skills,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        InfoLine(
            label = "Contact",
            value = contact,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        AvailabilityBadge(
            isAvailable = isAvailable,
            onClick = onAvailabilityClick,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        ContactButton(
            text = "Contacter $name",
            onClick = onContactClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

// En-tête : nom + rôle sur un fond coloré.
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier
    ) {
        // padding interne
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(
                text = role,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

// Courte description du profil.
@Composable
fun ProfileDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "À propos")
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Titre de section réutilisé plusieurs fois dans la fiche.
@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(bottom = 4.dp)
    )
}

// Liste des compétences : un SkillItem par compétence.
@Composable
fun SkillList(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Compétences")
        skills.forEach { skill ->
            SkillItem(
                skill = skill,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }
    }
}

// Une compétence affichée dans une petite "pastille".
@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        modifier = modifier
    ) {
        // padding interne
        Text(
            text = skill,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

// Information secondaire sous la forme "Libellé : valeur".
@Composable
fun InfoLine(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = label)
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Zone cliquable personnalisée -> on ajoute un rôle et une description pour l'accessibilité
@Composable
fun AvailabilityBadge(
    isAvailable: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val text = if (isAvailable) "Disponible pour un stage" else "Non disponible actuellement"
    val color = if (isAvailable) {
        MaterialTheme.colorScheme.tertiaryContainer
    } else {
        MaterialTheme.colorScheme.errorContainer
    }

    Surface(
        color = color,
        modifier = modifier
            .fillMaxWidth()
            .clickable(role = Role.Button, onClick = onClick)
            .semantics {
                contentDescription = "$text. Appuyer pour voir les détails."
            }
    ) {
        // padding interne
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(16.dp)
        )
    }
}

// Bouton d'action : il signale le clic au parent via le callback onClick.
@Composable
fun ContactButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, name = "Profil Android junior - disponible")
@Composable
fun ProfileScreenAndroidJuniorPreview() {
    ProfilComposeTheme {
        ProfileScreen(
            name = "Alex Martin",
            role = "Développeur Android junior",
            description = "Étudiant en informatique passionné par le mobile. " +
                "J'aime concevoir des interfaces claires avec Jetpack Compose.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git", "Material 3"),
            contact = "alex.martin@example.com",
            isAvailable = true,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Profil full-stack - non disponible")
@Composable
fun ProfileScreenFullStackPreview() {
    ProfilComposeTheme {
        ProfileScreen(
            name = "Camille Durand",
            role = "Développeuse full-stack",
            description = "Cinq ans d'expérience sur des applications web et mobiles, " +
                "de l'API jusqu'à l'interface.",
            skills = listOf("TypeScript", "React", "Node.js", "PostgreSQL", "Docker"),
            contact = "camille.durand@example.com",
            isAvailable = false,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}
