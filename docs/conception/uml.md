---
title: Conception - Diagrammes UML
---

# Diagrammes UML

## Diagrammes de classes

- Modèle de données orienté objet
![Diagramme de classe](../../besoins/diagrammes/diagrammedeclasse.jpg)


CourseController – CourseService

_____

Cardinalité : 1 ↔ 1

Chaque CourseController est associé à une unique instance de CourseService.
Le contrôleur délègue toutes les opérations liées aux cours (recherche, comparaison, vérification d’éligibilité) au service.
Le CourseService contient la logique métier et l’accès aux données externes (API distante), tandis que le contrôleur se limite à la gestion des requêtes HTTP.
_____



CourseService – Course

Cardinalité : 1 ↔ 0..*

Un CourseService manipule plusieurs objets Course, par exemple lors de la récupération d’une liste de cours ou de la comparaison de plusieurs cours.
Chaque objet Course représente une entité métier décrivant un cours (id, nom, crédits, prérequis, horaires).
Les cours sont utilisés par le service mais restent indépendants de celui-ci.

_____

CourseService – EligibilityResult

Cardinalité : 1 ↔ 0..*

Le CourseService produit des objets EligibilityResult lors des vérifications d’éligibilité d’un étudiant à un cours.
Chaque EligibilityResult contient l’état d’éligibilité ainsi que les prérequis manquants.
Ces objets servent uniquement de résultat métier et sont générés à la demande par le service.

_____

AvisController – AvisService

Cardinalité : 1 ↔ 1

Le AvisController est lié à une seule instance de AvisService.
Le contrôleur reçoit les requêtes liées aux avis (création, consultation) et délègue leur traitement au service.
Le AvisService gère la persistance des avis dans un fichier JSON.

_____

AvisService – Avis

Cardinalité : 1 ↔ 0..*

Un AvisService gère une collection d’objets Avis.
Chaque Avis représente l’évaluation d’un cours par un utilisateur (difficulté, charge, commentaire, auteur).
Les avis sont créés, lus et mis à jour exclusivement via le service.

_____

UserController – UserService

Cardinalité : 1 ↔ 1

Chaque UserController possède une seule instance de UserService.
Le contrôleur se charge des interactions HTTP tandis que le service encapsule toute la logique métier liée aux utilisateurs (création, mise à jour, suppression).

_____

UserService – User

Cardinalité : 1 ↔ 0..*

Le UserService maintient une collection d’objets User, stockée dans une structure de type Map.
Chaque User représente un utilisateur du système avec ses informations personnelles (id, nom, email).
Les utilisateurs sont manipulés uniquement via le service.

_____

ResultatController – ResultatService

Cardinalité : 1 ↔ 1

Le ResultatController est associé à un unique ResultatService.
Il permet de récupérer les résultats académiques d’un étudiant à partir de son identifiant.
Toute la logique d’accès aux données est centralisée dans le service.

_____

ResultatService – ResultatAcademique

Cardinalité : 1 ↔ 0..*

Le ResultatService gère des objets ResultatAcademique, lus depuis un fichier CSV.
Chaque résultat académique contient les informations scolaires d’un étudiant (programme, moyenne, score, crédits).
Ces objets sont fournis en lecture seule par le service.

_____

ProgramController – ProgramService

Cardinalité : 1 ↔ 1

Le ProgramController interagit avec une unique instance de ProgramService.
Le service se charge de la récupération des informations de programmes à partir d’une API externe.

_____

ProgramService 

Cardinalité : 1 ↔ 0..*

Le ProgramService manipule des objets représentant des programmes académiques récupérés depuis une API distante.
Ces objets sont utilisés comme données de consultation.

_____

IService – Services (CourseService, AvisService, UserService)

Relation : Implémentation (héritage d’interface)

Les classes CourseService, AvisService et UserService implémentent l’interface générique IService.
Cette interface définit un ensemble commun d’opérations CRUD (create, read, update, delete) afin d’assurer une structure uniforme et cohérente entre les différents services

## Diagrammes de séquence

![Diagramme de sequence](../../besoins/diagrammes/diagrammedesequence1.jpg)
L’étudiant demande la recherche d’un cours par sigle.
Le contrôleur transmet la requête au service, qui interroge l’API Planifium, transforme les données reçues, puis renvoie la liste des cours trouvés.
Le contrôleur affiche soit les résultats, soit un message d’erreur si aucun cours n’est disponible.

![Diagramme de sequence](../../besoins/diagrammes/diagrammedesequence2.jpg)
L’étudiant envoie une liste de sigles à comparer.
Le contrôleur appelle le service, qui récupère les informations de chaque cours via l’API Planifium.
Une fois les données réunies, le contrôleur affiche le tableau comparatif, ou un message d’erreur si la liste contient moins de deux cours.

![Diagramme de sequence](../../besoins/diagrammes/diagrammedesequence3.jpg)
L’étudiant soumet un avis.
Le contrôleur envoie l’avis au service, qui le valide.
Si l’avis est valide, il est enregistré et envoyé au bot Discord, puis un message de confirmation est affiché.
Si l’avis est invalide, un message d’erreur est affiché à l’étudiant.