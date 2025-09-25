---
title: Analyse des besoins - Présentation générale
---

# Présentation du projet

## Méthodologie pour la cueillette des données

TODO: Préciser comment les besoins ont été collectés (entrevues, questionnaires, brainstorming, etc.).

## Description du domaine

### Fonctionnement

### Acteurs

### Dépendances

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

    maintCes formats imposent d’une certaine manière ce que peut intégrer et utiliser l’application.  

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