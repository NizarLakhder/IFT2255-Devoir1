# Devoir 2 – IFT2255 (Génie logiciel)

Ce dépôt contient le livrable complet du **Devoir 2 – Conception et prototype** du cours *IFT2255 (Génie logiciel)* à l’Université de Montréal.

L’objectif du projet est de **concevoir et implanter un prototype fonctionnel** d’une plateforme d’aide au choix de cours pour les étudiants du DIRO (Département d’informatique et de recherche opérationnelle).  
Cette plateforme combine :

- **Les données officielles de Planifium** (cours, prérequis, horaires, crédits, etc.)  
- **Des avis étudiants** recueillis via un bot Discord  
- Une **interface console** pour tester les cas d’utilisation  
- Une **API REST (Javalin)** permettant l’accès programmatique aux données  

---

---

##  Objectifs du Devoir 2

Le **Devoir 2** consiste à :

1. **Concevoir la solution logicielle complète**
   - Diagrammes UML détaillés (séquence, classes, composants)
   - Architecture logicielle (modèle C4 – niveaux 3 )
   - Modélisation des interactions entre la console, l’API REST et les services

2. **Implanter un prototype fonctionnel**
   - Serveur **Javalin REST** permettant d’exposer les données de cours
   - Application **console** pour interagir avec l’utilisateur
   - Intégration dynamique avec **l’API Planifium**

3. **Démontrer les cas d’utilisation principaux :**
   - Recherche de cours  
   - Consultation détaillée  
   - Comparaison de plusieurs cours  

---

##  Prérequis

- **Java 17+**
- **Maven 3.8+**
- **Connexion Internet** (nécessaire pOour accéder à l’API Planifium)
- (Facultatif) MkDocs pour visualiser le rapport

---

##
IFT2255-Devoir1/rest-api puis mvn test pour réaliser les tests unitaire , l'oracle de tests se situent dans la section evaluation.md

## Répartition des taches 

tarek zerroug : implémentation , bot discord  , révision Cu , 
Nizar Lakhder : diagramme C3 .
Alae aloui : révision , rapport , diagramme de séquence
Yassine Benbouabid : diagramme d'activité


## Exécution du projet


Aller dans la dossier IFT2255-Devoir1/rest-api ou se situe le fichier pom.xml puis éxecuter mvn clean compile , ensuite :

Pour lancer le serveur javalin  : mvn exec:java -D exec.mainClass="com.diro.ift2255.Main"
Pour lancer l'application console : mvn exec:java -D exec.mainClass="com.diro.ift2255.console.MainConsole"