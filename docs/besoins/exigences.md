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

TODO: Identifier les exigences critiques.

## Types d'utilisateurs

> Identifier les différents profils qui interagiront avec le système.

| Type d’utilisateur | Description | Exemples de fonctionnalités accessibles |
|--------------------|-------------|------------------------------------------|
| Utilisateur invité | Accès limité, pas d’authentification | Consultation des ressources |
| Utilisateur authentifié | Compte personnel, fonctions principales | Réservation, historique |
| Administrateur | Droits étendus, gestion des ressources | Création/suppression de ressources, gestion des utilisateurs |

<!-- TODO: Détailler selon le périmètre du projet. -->

## Infrastructures

> Informations sur l’environnement d’exécution cible, les outils ou plateformes nécessaires.

- Le système sera hébergé sur un serveur Ubuntu 22.04.
- Base de données : PostgreSQL version 15.
- Serveur Web : Nginx + Gunicorn (pour une app Python, par exemple).
- Framework principal : [À spécifier selon le projet].

<!-- TODO: Compléter selon le stack technique prévu. -->
