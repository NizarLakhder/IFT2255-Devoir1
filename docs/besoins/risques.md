---
title: Analyse des besoins - Risques
---

# Analyse des risques

## Identification des risques

La réussite du projet dépend de plusieurs facteurs techniques, humains et organisationnels.  
Cette section présente les principaux risques identifiés ainsi que les mesures prévues pour les atténuer.



### Risque 1 – Dépendance aux sources externes (Planifium, Discord, résultats académiques)
Le système s’appuie fortement sur des services externes comme **Planifium**, **Discord** et les **bases de résultats académiques**.  
Une modification de ces APIs ou une panne pourrait rendre certaines fonctionnalités inaccessibles.  

**Probabilité :** Élevée  
**Impact :** Élevé  
**Mesures de mitigation :**

- Mettre en place un mécanisme de mise en cache local pour éviter les interruptions.  
- Adapter rapidement les requêtes en cas de changement de structure des APIs.  
- Prévoir des messages d’erreur clairs pour informer l’utilisateur.  
- Maintenir une documentation technique à jour pour les connexions externes.


### Risque 2 – Problèmes de performance et de charge du serveur
Lors des périodes critiques (comme le choix de cours), un grand nombre d’étudiants peuvent utiliser la plateforme simultanément, ce qui risque de la ralentir ou de la rendre indisponible.  

**Probabilité :** Moyenne  
**Impact :** Élevé  
**Mesures de mitigation :**

- Prévoir un hébergement évolutif (scalable) avant les périodes de pointe.  
- Effectuer des tests de charge et d’optimisation réguliers.  
- Mettre en place un système de surveillance du serveur pour détecter les problèmes avant qu’ils n’affectent les utilisateurs.


### Risque 3 – Fiabilité et pertinence des avis étudiants
Les avis laissés par les étudiants peuvent être incomplets, biaisés ou obsolètes, ce qui compromettrait la fiabilité des recommandations.  

**Probabilité :** Moyenne  
**Impact :** Moyen  
**Mesures de mitigation :**

- Afficher les avis seulement lorsqu’un minimum de 5 contributions est atteint.  
- Intégrer un système de signalement pour supprimer les avis inappropriés.  
- Agréger les avis pour en extraire une tendance plus représentative.


### Risque 4 – Incohérence entre les données officielles et les avis étudiants
Les données provenant de Planifium, des fichiers académiques et de Discord peuvent parfois être désynchronisées ou contradictoires.  

**Probabilité :** Moyenne  
**Impact :** Moyen  
**Mesures de mitigation :**

- Ajouter un module de validation et d’horodatage des données.  
- Synchroniser régulièrement les sources officielles et communautaires.  
- Afficher la date de mise à jour des informations pour assurer la transparence.


### Risque 5 – Sécurité et confidentialité des données (conformité à la Loi 25)
Le système manipule des données sensibles (profils étudiants, avis, connexions). Une mauvaise gestion pourrait compromettre la vie privée des utilisateurs.  

**Probabilité :** Faible à moyenne  
**Impact :** Élevé  
**Mesures de mitigation :**

- Utiliser le chiffrement HTTPS et le hachage des mots de passe.  
- Anonymiser les données avant leur affichage public.  
- Respecter les politiques de sécurité de l’Université de Montréal et la Loi 25 sur la protection des renseignements personnels.


### Risque 6 – Absence prolongée d’un membre clé de l’équipe
La non-disponibilité d’un membre essentiel pourrait ralentir la progression du projet ou nuire à la cohérence du travail.  
**Probabilité :** Moyenne  
**Impact :** Élevé  
**Mesures de mitigation :**

- Répartir clairement les responsabilités entre les membres.  
- Documenter régulièrement le travail effectué.  
- Favoriser le pair programming pour éviter toute dépendance à une seule personne.


### Risque 7 – Adoption limitée de la plateforme par les étudiants
Même si la plateforme est fonctionnelle, son adoption peut être faible si elle ne répond pas bien aux besoins réels des étudiants ou si elle manque de visibilité.  

**Probabilité :** Moyenne  
**Impact :** Moyen  
**Mesures de mitigation :**

- Promouvoir le projet auprès des associations étudiantes et sur les réseaux sociaux.  
- Soigner l’ergonomie et la simplicité de l’interface.  
- Mettre en place des mécanismes de rétroaction pour recueillir et intégrer les suggestions des utilisateurs.

---

## Modification du processus opérationnel

La mise en place du système pourrait modifier certaines pratiques actuelles :  
- **Consultation des cours** : auparavant dispersée entre plusieurs plateformes, elle sera centralisée.  
- **Collecte d’avis étudiants** : d’un processus informel (ex. discussions Discord) à un mécanisme structuré et intégré.  
- **Choix de cours** : passage d’un processus manuel et fastidieux à un processus guidé et assisté.
