---
title: Analyse des besoins - Cas d'utilisation
---

# Cas d'utilisation

## Vue d’ensemble

TODO: Introduction aux cas d’utilisation du système.

## Liste des cas d’utilisation

| ID   | Nom                     | Acteurs principaux | Description                                                                                   |
|------|-------------------------|--------------------|-----------------------------------------------------------------------------------------------|
| CU01 | Consulter le catalogue Planifium | Étudiant | 1. L’étudiant accède à la section de recherche de cours.<br>2. Le système interroge la Planifium API pour obtenir la liste officielle des cours disponibles.<br>3. L’étudiant saisit un code ou un titre de cours.<br>4. Le système affiche la liste correspondante des cours disponibles. |
| CU02 | Vérifier les prérequis et contraintes | Étudiant | 1. L’étudiant sélectionne un cours qui l’intéresse.<br>2. Le système récupère les informations de programme et les prérequis associés.<br>3. Le système compare ces informations avec le profil académique de l’étudiant.<br>4. Le système affiche si l’étudiant est éligible ou non.<br>5. L’étudiant ajuste éventuellement ses choix en fonction du résultat. |
| CU03 | Consulter avis étudiants | Étudiant | 1. L’étudiant accède à la section *Avis étudiants*.<br>2. Le système regroupe les avis provenant de sources informelles (forums, Discord, bouche-à-oreille).<br>3. Le système affiche les avis qualitatifs et les estimations de difficulté.<br>4. L’étudiant lit et analyse ces avis pour mieux comprendre la charge et la difficulté du cours. |
| CU04 | Comparer plusieurs cours | Étudiant | 1. L’étudiant sélectionne plusieurs cours à comparer.<br>2. Le système rassemble les informations collectées (officielles et avis étudiants).<br>3. Le système génère un tableau comparatif (charge de travail, difficulté, taux de réussite, avis).<br>4. L’étudiant visualise le classement des cours selon ses critères.<br>5. L’étudiant ajuste sa sélection de cours. |
| CU05 | Prendre une décision | Étudiant | 1. L’étudiant examine les comparaisons et les avis étudiants.<br>2. Le système propose un résumé des choix possibles.<br>3. L’étudiant sélectionne le cours qui correspond le mieux à ses critères.<br>4. Le système enregistre ce choix comme décision finale. |
| CU06 | S’inscrire | Étudiant | 1. L’étudiant envoie une demande d’inscription à un cours choisi.<br>2. Le système transmet cette demande à l’Administration.<br>3. L’Administration traite la demande et renvoie une confirmation ou un refus.<br>4. Le système notifie l’étudiant du statut final de son inscription. |


## Diagramme de cas d'utilisation 

Diagramme de cas d'utilisation 

![Diagramme de CU](diagrammes/diagramme-CU.jpg)

## Détail

### CU01 - Connexion

**Acteurs** : Utilisateur (principal)
**Préconditions** : 
**PostConditions** :
**Déclencheur** :   
**Dépendances** :   
**But** :
