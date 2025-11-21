---
title: Conception - Diagrammes UML
---

# Diagrammes UML

## Diagrammes de classes

- Modèle de données orienté objet
![Diagramme de classe](../../besoins/diagrammes/diagrammedeclasse.jpg)
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