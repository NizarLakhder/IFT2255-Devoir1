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

# plateforme de gesion de cours - planifium 

## Lien vers le repo github
 
[https://github.com/NizarLakhder/IFT2255-Devoir1](https://github.com/NizarLakhder/IFT2255-Devoir1)

## Équipe

- **`M1`:** Nizar Lakhder (20229915) #nizarlk
- **`M2`:** Alae aloui (20253423) #alae8804
- **`M3`:** Tarek Zerroug  (20293977) #tarek8720 
- **`M4`:** Yassine Benbouabid (20257585 #blueishblue)

## Description du projet

#### Objectif du processus
Le projet consiste à concevoir une plateforme web intelligente, accessible via une API REST, destinée aux étudiants pour les aider à prendre des décisions éclairées dans leur choix de cours.
Cette plateforme vise à :
Centraliser les données officielles (via l’API Planifium et les résultats académiques agrégés) et informelles (avis étudiants recueillis sur Discord) ;
Fournir des tableaux de bord interactifs permettant de visualiser la charge de travail, le taux de réussite et les moyennes des cours ;
Offrir une recherche intelligente et personnalisée selon le profil de l’étudiant ;
Permettre la comparaison de plusieurs cours pour estimer la charge combinée et la compatibilité des choix ;
Assurer la confidentialité des données et le respect des normes légales (Loi 25).

---

#### Acteurs impliqués
- **Étudiant** : Cherche, compare et choisit ses cours  
- **Administration** : Fournit de l’information sur les cours et gère les inscriptions  
- **Planifium API** : Donne accès au catalogue officiel des programmes, des cours et des horaires  
- **Système d’information (résultats académiques agrégés)** : Regroupe les résultats globaux d’un cours donné à une session précise (moyenne finale, nombre d’étudiants inscrits, nombre d’échecs)  
- **Sources informelles (Discord, forum, bouche-à-oreille)** : Regroupe les avis d’autres étudiants  

---
#### Étapes du processus

| Étape | Acteur                    | Action                                             | Entrée                                                                           | Sortie                                                     |   |
| ----- | ------------------------- | -------------------------------------------------- | -------------------------------------------------------------------------------- | ---------------------------------------------------------- | - |
| 1     | Étudiant                  | Se connecter au système                            | Identifiants (nom d’utilisateur, mot de passe)                                   | Accès sécurisé à la plateforme                             |   |
| 2     | Étudiant                  | Consulter le catalogue Planifium                   | Code, titre ou mots-clés de cours                                                | Requête envoyée à l’API Planifium                          |   |
| 3     | **Système Planifium**     | Fournir les informations officielles sur les cours | Requête de l’étudiant                                                            | Liste des cours (titre, crédits, horaire, prérequis, etc.) |   |
| 4     | Étudiant                  | Vérifier les prérequis et contraintes              | Informations du cours et du programme                                            | Liste de cours éligibles                                   |   |
| 5     | **Système Discord / Bot** | Extraire et agréger les avis étudiants             | Messages et réactions des étudiants sur Discord                                  | Base d’avis anonymisée (difficulté, charge, satisfaction)  |   |
| 6     | Étudiant                  | Consulter les avis étudiants                       | Données agrégées (Discord + base locale)                                         | Synthèse des avis et estimations de difficulté             |   |
| 7     | Étudiant                  | Comparer plusieurs cours                           | Informations collectées (officielles et avis)                                    | Tableau comparatif : charge, difficulté, taux d’échec      |   |
| 8     | Étudiant                  | Personnaliser les recommandations                  | Profil personnel (intérêts, niveau, disponibilité, préférences théorie/pratique) | Classement personnalisé des cours recommandés              |   |
| 9     | Étudiant                  | Sauvegarder ou exporter ses choix                  | Sélection finale de cours                                                        | Liste personnelle enregistrée ou exportée                  |   |
| 10    | **Administrateur**        | Gérer les données du système                       | Données Planifium, résultats académiques, avis étudiants                         | Mise à jour de la base et supervision du système           |   |


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

