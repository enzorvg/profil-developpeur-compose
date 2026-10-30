# Profil développeur Compose

Application Android en Jetpack Compose qui affiche la fiche profil d'un développeur :
nom, rôle, description, compétences, contact et disponibilité.
Un bouton « Contacter » et une zone cliquable « Disponible pour un stage » remontent le clic via des callbacks.

![Capture de l'application](docs/screenshot.png)

## Notions utilisées

Composables, paramètres, modifiers (et chaînage), padding externe / interne, callbacks, `Scaffold`, previews, accessibilité de base.

## Explications

1. **Composables créés** : `ProfileScreen`, `ProfileHeader`, `ProfileDescription`, `SectionTitle`, `SkillList`, `SkillItem`, `InfoLine`, `AvailabilityBadge`, `ContactButton`.
2. **Écran principal** : `ProfileScreen`, appelé dans le `Scaffold` de `MainActivity`.
3. **Padding externe** : dans `ProfileScreen`, le parent passe un `Modifier.padding(...)` à chaque enfant pour le placer.
4. **Padding interne** : dans `ProfileHeader`, `SkillItem` et `AvailabilityBadge`, pour espacer le contenu du bord du composant.
5. **Callback** : `ContactButton` et `AvailabilityBadge` reçoivent un `onClick`, transmis depuis `MainActivity`.
6. **Accessibilité** : `AvailabilityBadge` (zone cliquable personnalisée) a `role = Role.Button` et une `contentDescription`. `ContactButton` est un `Button`, déjà reconnu comme bouton.
7. **Réutilisables** : les données et les actions sont passées en paramètres et chaque composant accepte un `modifier`. Les deux previews affichent deux profils différents avec le même code.
