---
title: Analyse des besoins - Risques
---

# Analyse des risques

## Identification des risques

TODO: Lister les principaux risques identifiés (techniques, humains, organisationnels).

### Risque 1 – Changement ou indisponibilité de l’API Planifium
  - Si l’API Planifium modifie sa structure ou devient temporairement inaccessible, le système perdra l’accès aux données officielles des cours.
  - Solution : Implémenter un mécanisme de cache local et un module d’adaptation des requêtes.

### Risque 2 – Problèmes de performance et de charge serveur
  - En période de choix de cours, le nombre d’utilisateurs simultanés peut fortement augmenter, entraînant un ralentissement du système.
  - Solution : Prévoir un hébergement scalable   avant les périodes critiques.
 
### Risque 3: Dépendance à la Discord API pour les avis étudiants
- Si la structure ou les permissions de la Discord API changent, la collecte d’avis pourrait échouer.
- Solution : Mettre en place un système de sauvegarde locale et une documentation claire de l’API pour adaptation rapide.
 
### Risque 4: Risque d’incohérence entre les données officielles et les avis étudiants
- Les données provenant de différentes sources (Planifium, Disco rd) peuvent être désynchronisées ou contradictoires.
- Solution : Ajouter un module de validation qui enregistre la date et l’heure des informations pour assurer leur cohérence.
 
### Risque 5: Risques de sécurité et de confidentialité
- Le système manipule des données personnelles (profil étudiant, connexions). Une faille pourrait compromettre la confidentialité.
- Solution : Chiffrer les communications (HTTPS, hachage des mots de passe) et respecter la Loi 25 sur la protection des données au Québec.
 

## Modification du processus opérationnel

> Si la mise en place du système modifie des processus internes ou des pratiques actuelles, il est essentiel de les identifier ici.