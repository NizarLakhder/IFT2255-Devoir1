---
title: Évaluation et tests
---

<style>
    @media screen and (min-width: 76em) {
        .md-sidebar--primary {
            display: none !important;
        }
    }
</style>

## Oracles de tests - TDD 

Cette section décrit, pour chaque cas d’utilisation principal, au moins un scénario de test formalisé.  
Pour chaque test, on précise les entrées, le résultat attendu et les effets de bord attendus.

### CU1 – Rechercher un cours

Test CU1.1 – Recherche par sigle exact existant

- Cas d’utilisation couvert  
  CU1 Rechercher un cours

- Entrées  
  Sigle saisi: "IFT2255"

- Préconditions  
  L’API Planifium (ou le client HTTP simulé) retourne un JSON contenant au moins un cours avec id = "IFT2255".

- Résultat attendu (valeur de retour)  
  CourseService.rechercherCours("IFT2255") retourne une liste de taille 1 dont:
  - element[0].id = "IFT2255"
  - element[0].name = "Génie logiciel"
  - element[0].credits = 3.0

- Effets de bord attendus  
  Aucun état persistant modifié.  
  Dans la console, en mode interactif, le système affiche une section “Résultats :” suivie d’une ligne  
  "- IFT2255 | Génie logiciel (3,0 crédits)".

Test CU1.2 – Aucun cours trouvé

- Cas d’utilisation couvert  
  CU1 Rechercher un cours

- Entrées  
  Sigle saisi: "XXX0000"

- Préconditions  
  L’API Planifium (ou le client simulé) retourne un tableau JSON vide.

- Résultat attendu (valeur de retour)  
  CourseService.rechercherCours("XXX0000") retourne une liste vide.

- Effets de bord attendus  
  En console, le message "Aucun cours trouvé." est affiché.  
  Pas de crash, pas d’exception non gérée.

Test CU1.3 – Entrée utilisateur invalide dans le menu

- Cas d’utilisation couvert  
  CU1 Rechercher un cours (flux alternatif)

- Entrées  
  Dans le menu principal, l’utilisateur tape "MAT1400" au lieu d’un nombre pour le choix.

- Préconditions  
  L’application est dans la boucle principale du menu.

- Résultat attendu  
  Le programme ne plante pas. La saisie est ignorée.

- Effets de bord attendus  
  Le message "Veuillez entrer un nombre valide." est affiché, puis le menu principal est réaffiché.

### CU2 – Voir les détails d’un cours

Test CU2.1 – Détails d’un cours existant

- Cas d’utilisation couvert  
  CU2 Voir les détails d’un cours

- Entrées  
  Sigle saisi: "MAT1400"

- Préconditions  
  L’API retourne un JSON correspondant à un cours avec:
  - id: "MAT1400"
  - name: "Calcul 1"
  - credits: 4.0
  - description non vide

- Résultat attendu (valeur de retour)  
  CourseService.getCoursParCode("MAT1400") retourne un objet Course non nul avec les valeurs ci-dessus.

- Effets de bord attendus  
  En console, les informations sont affichées sous la forme:
  - "Sigle : MAT1400"
  - "Nom : Calcul 1"
  - "Crédits : 4.0"
  - "Description : …"

Test CU2.2 – Cours inexistant

- Cas d’utilisation couvert  
  CU2 Voir les détails d’un cours (flux d’erreur)

- Entrées  
  Sigle saisi: "ZZZ9999"

- Préconditions  
  L’API (ou le client simulé) retourne un code HTTP 404.

- Résultat attendu (valeur de retour)  
  CourseService.getCoursParCode("ZZZ9999") retourne null.

- Effets de bord attendus  
  En console, le message "Cours introuvable." est affiché.  
  Pas de plantage de l’application.

### CU3 – Comparer des cours

Test CU3.1 – Comparaison de deux cours valides

- Cas d’utilisation couvert  
  CU3 Comparer des cours

- Entrées  
  Sigles saisis: "IFT2255,MAT1400"

- Préconditions  
  - getCoursParCode("IFT2255") retourne un Course pour Génie logiciel, 3 crédits.  
  - getCoursParCode("MAT1400") retourne un Course pour Calcul 1, 4 crédits.

- Résultat attendu (valeur de retour)  
  CourseService.getCoursParCodes(["IFT2255", "MAT1400"]) retourne une liste de taille 2:  
  - element[0].id = "IFT2255"  
  - element[1].id = "MAT1400"

- Effets de bord attendus  
  En console, la section "=== Comparaison des cours ===" est affichée, suivie des deux fiches cours formatées:
  - "IFT2255 : Génie logiciel (3,0 crédits)"  
  - "MAT1400 : Calcul 1 (4,0 crédits)"

Test CU3.2 – Trop peu de cours valides

- Cas d’utilisation couvert  
  CU3 Comparer des cours (flux alternatif)

- Entrées  
  Sigles saisis: "IFT2255,XXX0000"

- Préconditions  
  - getCoursParCode("IFT2255") retourne un cours valide.  
  - getCoursParCode("XXX0000") retourne null (404).

- Résultat attendu (valeur de retour)  
  CourseService.getCoursParCodes(["IFT2255", "XXX0000"]) retourne une liste de taille 1.

- Effets de bord attendus  
  Dans MainConsole, le système détecte qu’il y a moins de deux cours valides et affiche:  
  "Veuillez entrer au moins deux cours valides."

### CU4 – Consulter les avis d’un cours

Test CU4.1 – Lecture des avis à partir du fichier JSON

- Cas d’utilisation couvert  
  CU4 Consulter les avis d’un cours

- Entrées  
  Appel à AvisService.lireAvis() sans argument.

- Préconditions  
  Le fichier dataDiscord/avis.json existe et contient une liste JSON de plusieurs objets Avis, dont un avec:
  - cours = "IFT2255"
  - difficulte = 3
  - charge = 2
  - commentaire non vide

- Résultat attendu (valeur de retour)  
  AvisService.lireAvis() retourne une liste non vide contenant un Avis pour le cours "IFT2255" avec les champs correctement mappés.

- Effets de bord attendus  
  Aucun effet de bord autre que la lecture du fichier.  
  Aucune exception non gérée ne doit être levée si le fichier est bien formaté.

Test CU4.2 – Fichier d’avis absent

- Cas d’utilisation couvert  
  CU4 Consulter les avis d’un cours (flux d’erreur)

- Entrées  
  Appel à AvisService.lireAvis() alors que le fichier avis.json n’existe pas sur le disque.

- Préconditions  
  Le chemin dataDiscord/avis.json est absent.

- Résultat attendu (valeur de retour)  
  La méthode retourne une liste vide.

- Effets de bord attendus  
  Un message d’information est éventuellement affiché en console ("Aucun avis encore enregistré").  
  L’application continue de fonctionner normalement.