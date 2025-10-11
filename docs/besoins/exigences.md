---
title: Analyse des besoins - Exigences
---

# Exigences

## Exigences fonctionnelles

TODO: Liste des fonctions que le système doit accomplir.

Exemple :

- [ ] EF1 : Le système doit permettre à un étudiant de se connecter à la plateforme à l’aide d’identifiants sécurisés
- [ ] EF2 : Le système doit permettre à l’étudiant de consulter la liste officielle des cours à partir de l’API Planifium.
- [ ] EF1 : Le système doit afficher les avis étudiants agrégés provenant de la Discord API pour chaque cours.
- [ ] EF2 : Le système doit permettre à l’étudiant de comparer plusieurs cours selon la charge de travail, la difficulté et le taux        de réussite.
- [ ] EF1 : Le système doit générer des recommandations de cours personnalisées selon le profil et les préférences de l’étudiant.
- [ ] EF2 :Le système doit permettre à l’étudiant de soumettre une demande d’inscription, transmise au TGDE pour validation académique.

## Exigences non fonctionnelles

TODO: Contraintes de performance, sécurité, compatibilité, etc.

Exemple :

- [ ] ENF1 : Le système doit répondre en moins de 2 secondes pour les requêtes principales (recherche, affichage, comparaison).
- [ ] ENF2 : Les échanges de données entre la plateforme et les APIs externes (Planifium, Discord) doivent être sécurisés via HTTPS.
- [ ] ENF3 : L’application doit être compatible avec les principaux navigateurs (Chrome, Firefox, Safari).
- [ ] ENF4 : Le système doit respecter les normes de confidentialité et de protection des données personnelles (Loi 25 – Québec).
- [ ] ENF5 : L’interface doit être intuitive, claire et accessible pour des étudiants de différents profils (locaux, internationaux, débutants).
- [ ] ENF6 :Le système doit garantir une disponibilité d’au moins 99 % pendant les périodes critiques de choix de cours.
- [ ] ENF7 : Le système doit conserver les requêtes récentes pour éviter de retaper des recherches identiques.
- [ ] ENF8 : Le système doit bloquer les avis contenant des mots inappropriés ou offensants avant publication
- [ ] ENF9 : L’interface doit expliquer les erreurs de connexion pour assurer plus de securite
- [ ] ENF10 : Les avis étudiants doivent être anonymes, et ajouter un indicateur de fiabilité pour chaque avis.


## Priorisation

Toutes les exigences n’ont pas le même poids. Certaines sont critiques pour que le système soit utilisable des la première version, tandis que d’autres peuvent être considérées comme secondaires ou évolutives.  

| ID   | Exigence                                      | Priorité  | Justification |
|------|-----------------------------------------------|-----------|---------------|
| EF1  | Personnaliser ses choix de cours              | Critique  | Fonctionnalité centrale de la plateforme, cœur de la valeur ajoutée. |
| EF2  | Recherche de cours avec filtres               | Critique  | Indispensable pour la navigation et l’efficacité du système. |
| EF3  | Consulter les détails d’un cours              | Critique  | Sans cette information, la plateforme perd son utilité première. |
| EF6  | Vérification automatique des prérequis        | Critique  | Permet d’éviter des erreurs d’inscription et guide l’étudiant. |
| EF4  | Rédiger un avis étudiant                      | Important | Utile pour enrichir la plateforme, mais pas essentiel au démarrage. |
| EF5  | Afficher les avis (min. 5 avant publication)  | Important | Améliore l’expérience, mais dépend de la disponibilité d’assez d’avis. |
| EF7  | Gestion des connexions par l’administrateur   | Important | Nécessaire pour la maintenance, mais pas directement lié à l’étudiant. |
| EF8  | Adaptation selon le profil enregistré         | Secondaire| Fonctionnalité avancée qui peut être ajoutée dans une version ultérieure. |

## Types d'utilisateurs

> Identifier les différents profils qui interagiront avec le système.

| Type d’utilisateur | Description | Exemples de fonctionnalités accessibles |
|--------------------|-------------|------------------------------------------|
| Utilisateur invité | Accès limité, pas d’authentification | Consultation des ressources |
| Utilisateur authentifié | Compte personnel, fonctions principales | Réservation, historique |
| Administrateur | Droits étendus, gestion des ressources | Création/suppression de ressources, gestion des utilisateurs |

<!-- TODO: Détailler selon le périmètre du projet. -->

## Infrastructures

## Infrastructures et besoins matériels

Le système s’appuie sur une infrastructure standard pour assurer la performance et la fiabilité.

- Serveur d’hébergement : Ubuntu 22.04 LTS, avec Nginx + Gunicorn.  
- Base de données : PostgreSQL 15, pour centraliser les cours, profils étudiants et avis.  
- Framework applicatif : Python 3.11 (Flask ou Django).  
- Accès utilisateur : via un navigateur moderne (Chrome, Firefox, Edge) et connexion Internet stable.

### Solution de stockage
- Données officielles des cours récupérées via l’API Planifium 
- Résultats académiques intégrés depuis des fichiers CSV
- Avis étudiants collectés par un bot Discord (format JSON).
- Préférences utilisateurs stockées dans la base interne.  

### Solution d’intégration
- API Planifium : pour sigles, horaires et prérequis.  
- Bot Discord : pour centraliser les avis étudiants.  
- Import CSV : pour les données académiques.  
- API REST interne : pour permettre l’accès aux données par des applications tierces.
