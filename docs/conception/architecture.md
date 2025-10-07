---
title: Conception - Architecture
---

# Architecture du système

## Vue d’ensemble

- Description du type d’architecture retenue (ex. : monolithique, microservices, REST...)
- Raisons du choix

## Composants principaux

- Liste des modules ou services :
  - Module d’authentification
  - Gestion des utilisateurs
  - Interface (frontend)
  - API backend

## Communication entre composants

- Mécanismes d’échange : appels HTTP, WebSocket, messages, etc.
- Format des données : JSON, XML, etc.

# Modèle C4 – Architecture du système

Cette section présente la modélisation de l’architecture logicielle selon le **modèle C4**.  
Le but est de visualiser le système à différents niveaux d’abstraction, en illustrant les relations entre les acteurs, les conteneurs et les services externes.

---

##  Niveau 1 — Diagramme de contexte

Le diagramme de **niveau 1** montre le système dans son environnement global.  
Il met en évidence les **acteurs externes** (étudiant, API Planifium, Bot Discord) et le **système principal** : *Plateforme Choix de Cours UdeM*.

### Description
- **Acteur principal :** Étudiant (utilise la plateforme via une interface web)
- **Système principal :** Plateforme Choix de Cours UdeM
- **Systèmes externes :**
  - API Planifium : fournit les données officielles des cours
  - Bot Discord : fournit les avis étudiants agrégés

### Diagramme

![Diagramme C4 Niveau 1](../besoins/diagrammes/C4-niveau1.jpg)

---

##  Niveau 2 — Diagramme de conteneurs

Le diagramme de **niveau 2** détaille la structure interne de la plateforme.  
Il illustre les **conteneurs principaux**, leurs **rôles**, et les **mécanismes de communication** entre eux et les services externes.

### Composants principaux
- **Interface Web (Front-end)**  
  - Technologie : HTML, CSS, JavaScript  
  - Permet à l’étudiant de consulter, comparer et gérer ses cours  
  - Communique avec le backend via HTTP REST (JSON)

- **Backend API (Application principale)**  
  - Technologie : Java
  - Contient la logique métier et gère les requêtes entre le front, la base de données et les services externes  
  

- **Base de données interne**  
 
  - Stocke les comptes, profils et historiques d’étudiants

- **Systèmes externes :**
  - API Planifium — récupération des données officielles (HTTP GET / JSON)  
  - Bot Discord — récupération des avis étudiants (HTTP GET / JSON)  
  -  Système de recommandation — suggestions personnalisées (HTTP POST / JSON)

### Diagramme

![Diagramme C4 Niveau 2](../besoins/diagrammes/C4-niveau2.jpg)

---

## 🔁 Communication entre composants

| Source | Destination | Description du flux | Technologie |
|---------|--------------|---------------------|--------------|
| Étudiant | Interface Web | Interaction utilisateur (navigation, authentification) | HTTP (HTML/CSS/JS) |
| Interface Web | Backend API | Appels REST pour les fonctionnalités principales | HTTP REST / JSON |
| Backend API | Base de données | Lecture/écriture des profils et historiques | JDBC / SQL |
| Backend API | API Planifium | Récupération des données officielles des cours | HTTP GET / JSON |
| Backend API | Bot Discord | Récupération des avis étudiants agrégés | HTTP GET / JSON |
| Backend API | Système de recommandation | Envoi du profil et réception des suggestions | HTTP POST / JSON |

---


