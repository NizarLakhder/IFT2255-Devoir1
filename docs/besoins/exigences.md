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

TODO: Identifier les exigences critiques.

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

> Informations sur l’environnement d’exécution cible, les outils ou plateformes nécessaires.

- Le système sera hébergé sur un serveur Ubuntu 22.04.
- Base de données : PostgreSQL version 15.
- Serveur Web : Nginx + Gunicorn (pour une app Python, par exemple).
- Framework principal : [À spécifier selon le projet].

<!-- TODO: Compléter selon le stack technique prévu. -->
