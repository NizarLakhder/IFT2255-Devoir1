---
title: Analyse des besoins - Exigences
---

# Exigences

## Exigences fonctionnelles

TODO: Liste des fonctions que le système doit accomplir.

Exemple :

EF1 : L’étudiant peut se connecter à la plateforme à l’aide d’identifiants sécurisés.
EF2 : Le système affiche la liste officielle des cours via l’API Planifium, avec leurs détails (prérequis, co-requis, taux d’échec, nombre d’inscrits).
EF3 : Le système offre un filtre de recherche (sigle, titre, mots-clés, horaire).
EF4 : L’étudiant peut soumettre une demande d’inscription, transmise au TGDE pour validation académique.
EF5 : Le système génère des recommandations personnalisées selon le profil et les préférences enregistrées de l’étudiant.
EF6 : L’administrateur peut gérer les connexions aux sources externes (API Planifium, résultats académiques, bot Discord).
## Priorisation:
EF7 : L’étudiant peut rédiger un avis sur un cours suivi ; il sera publié lorsque le nombre minimal d’avis (≥ 5) sera atteint.
EF8 : L’étudiant peut personnaliser ses choix de cours selon ses préférences (intérêts, contraintes, charge de travail).
EF9 : L’étudiant peut comparer plusieurs cours selon la charge de travail, la difficulté et le taux de réussite.
EF10 : Le système présente les avis étudiants agrégés provenant du bot Discord et les relie à chaque cours.

## Exigences non fonctionnelles

TODO: Contraintes de performance, sécurité, compatibilité, etc.

Exemple :

- ENF1 : L’application doit être compatible avec les principaux navigateurs (Chrome, Firefox, Safari), les utilisateurs n’utilise pas le même navigateur, donc il faut que le site fonctionne bien partout.
- ENF2 : Le système doit respecter les normes de confidentialité et de protection des données personnelles (Loi 25 – Québec).
- ENF3 : L’interface doit être intuitive, claire et accessible pour des étudiants de différents profils (locaux, internationaux, débutants), même pour ceux qui ne sont pas à l’aise avec la technologie.
- ENF4 : Le système doit conserver les requêtes récentes pour éviter de retaper des recherches identiques, afin de gagner du temps.
- ENF5 : L’interface doit expliquer les erreurs de connexion car le système doit expliquer les erreurs en langage humain et proposer une solution.

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

- ENF6 :Le système doit garantir une disponibilité d’au moins 99 % pendant les périodes critiques de choix de cours, le systeme doit rester accessible quand tout le monde l’utilise, c'est le moment le plus important.
- ENF7 : Le système doit bloquer les avis contenant des mots inappropriés ou offensants avant publication, pour assurer le respect.
- ENF8 : Les avis étudiants doivent être anonymes, et ajouter un indicateur de fiabilité pour chaque avis, car ca permet d'exprimer leur avis librement, tout en aidant à savoir si un commentaire est crédible.
- ENF9 : Le système doit répondre en moins de 2 secondes pour les requêtes principales (recherche, affichage, comparaison) car le systeme doit être rapide à utiliser, si les pages prennent trop de temps à charger, les étudiants vont abandonner.
- ENF10 : Les échanges de données entre la plateforme et les APIs externes (Planifium, Discord) doivent être sécurisés via HTTPS, Les données échangées doivent être protégées.



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
