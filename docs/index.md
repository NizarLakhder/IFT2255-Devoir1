---
title: Vue d'ensemble
---

<style>
    @media screen and (min-width: 76em) {
        .md-sidebar--primary {
            display: none !important;
        }
    }
</style>

# Nom du projet

## Équipe

- **`M1`:** Nizar Lakhder (20229915) #nizarlk
- **`M2`:** Alae aloui (20253423) #alae8804
- **`M3`:** Tarek Zerroug  (20293977) #tarek8720 
- **`M4`:** Yassine Benbouabid (20257585 #blueishblue)

## Description du projet

#### Objectif du processus
Permet à un étudiant de choisir ses cours selon des critères établis par lui-même.  
Cela implique une démarche **manuelle et fragmentée**, où l’étudiant doit agréger lui-même des informations provenant de sources multiples.

---

#### Acteurs impliqués
- **Étudiant** : Cherche, compare et choisit ses cours  
- **Administration** : Fournit de l’information sur les cours et gère les inscriptions  
- **Planifium API** : Donne accès au catalogue officiel des programmes, des cours et des horaires  
- **Système d’information (résultats académiques agrégés)** : Regroupe les résultats globaux d’un cours donné à une session précise (moyenne finale, nombre d’étudiants inscrits, nombre d’échecs)  
- **Sources informelles (Discord, forum, bouche-à-oreille)** : Regroupe les avis d’autres étudiants  

---
#### Étapes du processus

| Étape | Acteur   | Action                                | Entrée                                        | Sortie                                          |   |
| ----- | -------- | ------------------------------------- | --------------------------------------------- | ----------------------------------------------- | - |
| 1     | Étudiant | Consulter le catalogue Planifium      | Code ou titre du cours                        | Liste de cours disponibles                      |   |
| 2     | Étudiant | Vérifier les prérequis et contraintes | Informations du cours et du programme         | Liste de cours éligibles                        |   |
| 3     | Étudiant | Consulter avis étudiants              | Forums, Discord, bouche-à-oreille             | Avis qualitatifs et estimations de difficulté   |   |
| 4     | Étudiant | Comparer plusieurs cours              | Informations collectées (officielles et avis) | Classement des cours selon charge et difficulté |   |
| 5     | Étudiant | Prendre une décision                  | Résultats de la comparaison                   | Choix final du cours                            |   |
| 6     | Étudiant | S’inscrire                            | Demande à l’administration                    | Inscription confirmée                           |   |

#### Contraintes du processus
1. **Informations dispersées et manque de centralisation** : Les informations nécessaires sont éparpillées sur différentes sources/sites.  
2. **Avis non standardisés** : Les avis ne sont pas forcément qualitatifs ou peuvent être biaisés, voire obsolètes.  
3. **Pas de personnalisation selon le profil de l’étudiant** : Le processus actuel ne prend pas en compte les préférences et réalités spécifiques des étudiants.  
4. **Temps et efforts requis** : Le processus manuel est long et exige une forte implication de l’étudiant.  
5. **Accessibilité et interface limitée** : Les plateformes ne sont pas conçues pour faciliter la recherche rapide ou la comparaison des cours, ni pour les étudiants ayant un handicap.  
6. **Confidentialité et légalité** : Certaines sources peuvent ne pas respecter la confidentialité ou la législation en vigueur (ex. Loi 25 au Québec).  

## Échéancier

| Taches                        | Terminé le    | Statut      | Responsable  |
|-------------------------------|---------------|-------------|--------------|
| Ouverture de projet           | 12 septembre  | ✅ Terminé  | `M1`         |
| Description du domaine        | 19 septembre  | 🔄 En cours | `M1` `M2`    |
| Identification des acteurs    | 19 septembre  | 🔄 En cours | `M2` `M3`    |
| Glossaire                     | 21 septembre  | ⏳ À venir  | `M3`         |
| Exigences Fonct et Non-Fonct  | 26 septembre  | ⏳ À venir  | `M1` `M4`    |
| Évaluation des risques        | 26 septembre  | ⏳ À venir  | `M2`         |
| Personas                      | 29 septembre  | ⏳ À venir  | `M1`         |
| Cas d'utilisation             | 3 octobre     | ⏳ À venir  | `M3`         |
| Diagramme d'activités         | 6 octobre     | ⏳ À venir  | `M4`         |
| Modèle C4                     | 6 octobre     | ⏳ À venir  | `M3`         |
| Prototype fonctionnel (bonus) | 10 octobre    | ⏳ À venir  | `M4`         |
| Rapport                       | 10 octobre    | ⏳ À venir  | `M1`         |

