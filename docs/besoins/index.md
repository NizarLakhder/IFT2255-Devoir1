---
title: Analyse des besoins - Présentation générale
---

# Présentation du projet

## Méthodologie pour la cueillette des données

TODO: Préciser comment les besoins ont été collectés (entrevues, questionnaires, brainstorming, etc.).

## Description du domaine

### Fonctionnement
Actuellement, un étudiant qui souhaite choisir ses cours doit consulter plusieurs sources (Planifium pour les sigles, résultats académiques disponibles sous forme de fichiers, discussions informelles entre étudiants, etc.).
La plateforme a pour objectif de regrouper ces informations et de les compléter avec des fonctionnalités sur mesure :
- filtrage des cours en fonction des envies et contraintes personnelles,  
- visualisation des avis étudiants,  
- vérification de l'admissibilité aux cours (prérequis et co-requis),  
- adaptation de l'affichage selon le profil de l'étudiant.

L'étudiant n'a donc plus à jongler entre différents outils : toutes les informations sont disponibles dans une seule interface.


### Acteurs
- **L’étudiant** est l’acteur principal. C’est lui qui utilise la plateforme pour rechercher ses cours, indiquer ses préférences (ex. matière plus pratique ou théorique), et donner un retour d’expérience après avoir suivi un cours.  
- **L’administrateur du système** joue un rôle en arrière-plan : il assure que la plateforme fonctionne bien et que les données sont bien connectées aux différentes sources.  
- **Les sources de données externes** participent aussi indirectement :  
    - Planifium fournit les informations officielles (sigles, horaires, prérequis).  
    - La *base des résultats académiques* donne des statistiques utiles (moyenne, taux d’échec, nombre d’inscrits).  
    - Le *bot Discord* recueille les avis des étudiants et les rend disponibles sous forme de données structurées.  

### Dépendances
Le système s’appuie largement sur ces trois sources de données externes :  
- **Planifium**, nécessaire pour obtenir les cours et leurs conditions d’accès.  
- **Les résultats académiques**, qui permettent d’évaluer la difficulté et la réussite des cours (moyenne, nombre d’inscrits, taux d’échec).  
- **Le bot Discord**, qui centralise les avis et retours d’expérience des étudiants.  
En plus de ça, la plateforme possède sa propre **base de données interne**, qui enregistre le profil de chaque étudiant (ses préférences, ses contraintes, etc.). Ces dépendances sont essentielles : sans elles, la plateforme ne pourrait pas remplir son rôle d’assistant fiable pour le choix de cours.

## Hypothèses et contraintes

### Hypothèses
TODO: Cette section sera complétée plus tard.

### Contraintes et règles du domaine

Avant de concevoir notre futur système, il est nécessaire de prendre en compte les limites et les règles en vigueur dans le domaine du choix de cours à l’Université de Montréal. 
Ces éléments constituent le cadre dans lequel notre solution devra évoluer.

#### Contraintes
- Dépendance à l’API Planifium: 
  L’accès aux informations officielles (sigles de cours, horaires, prérequis et co-requis) repose entièrement sur Planifium. Si cette API est indisponible ou modifiée, cela limite directement les activités possibles.  

- Formats de données imposés: 
  Les données proviennent de sources différentes et sont fournies dans des formats spécifiques :  

    - en **CSV** pour les résultats académiques (moyenne, nombre d’inscrits, échecs) ;  
    - en **JSON** pour les avis étudiants, via Discord.

  Ces formats définissent ce que l’application peut intégrer et exploiter.

- Conformité légale:  
  Le projet doit se conformer à la **Loi 25** du Québec sur la protection des renseignements personnels. Cela signifie que toutes les données étudiantes doivent être sécurisées et anonymisées avant leur diffusion.  

- Accessibilité technique: 
  L’information doit être accessible depuis différents supports (ordinateur, mobile, tablette) et une API REST doit permettre l’accès à des utilisateurs plus techniques.  

- Disponibilité et fiabilité des données:  
  Le bon fonctionnement du système dépendra de la qualité et de la régularité des données fournies par les sources officielles. Sans données fiables, les étudiants ne peuvent pas prendre de décisions éclairées.  


#### Règles du domaine
- Respect des prérequis académiques: 
  L’inscription à un cours n’est possible que si les prérequis et co-requis définis par l’Université sont respectés.  

- Seuil minimal pour l’affichage des avis:
  Pour éviter les biais, les avis étudiants ne doivent être affichés qu’à partir d’un minimum de **cinq contributions**.  

- Centralisation de l’information: 
  Les informations utiles aux étudiants sont actuellement éparpillées entre plusieurs sources. Le domaine impose qu’elles soient regroupées dans un même outil afin de favoriser la transparence.  

- Confidentialité des avis étudiants:  
  Les avis doivent rester anonymes et présentés de manière agrégée, afin de protéger l’identité des étudiants qui partagent leur expérience.  

- Prise en compte du profil étudiant: 
  Chaque étudiant a un parcours et des préférences différents (par exemple, intérêt pour les cours pratiques ou théoriques), le système doit les intégrer pour proposer des recommandations personnalisées.  