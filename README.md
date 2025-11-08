# Devoir 1 – IFT2255 (Génie logiciel)

Ce dépôt contient le livrable du **Devoir 1 – Analyse des besoins** du cours *IFT2255 (Génie logiciel)* à l’Université de Montréal.  
Le rapport est construit avec [MkDocs](https://www.mkdocs.org/) et le thème [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/).
Le projet consiste à concevoir et modéliser une plateforme d’aide au choix de cours pour les étudiants du DIRO, combinant données officielles (Planifium, résultats académiques) et avis étudiants (Discord)

##  Contenu du livrable

Le dépôt contient les éléments suivants :

Description du domaine : fonctionnement actuel, acteurs, dépendances 

Identification des acteurs et parties prenantes

Exigences fonctionnelles et non fonctionnelles

Contraintes et règles du domaine

Glossaire

Analyse des risques et hypothèses

Diagrammes UML :
Diagrammes de cas d’utilisation
Diagrammes d’activités (flux principaux)
Modèle C4 (niveaux 1 et 2) : architecture logicielle et interactions entre composants
Configuration MkDocs (mkdocs.yml) : génération automatique du rapport HTML


Répartition des tâches
Tarek Zerroug (20293977) #tarek8720
→ Modèle C4, code démonstratif

Alae Alaoui (20253423) #alae8804
→ Diagrammes de cas d’utilisation

Nizar Lakhder (20229915) #nizarlk
→ Analyse des risques, rédaction du rapport

Yassine Benbouabid (20257585) #blueishblue
→ Compréhension du domaine , description des flux principaux . 

##  Visualiser le rapport

Pour lancer le site en local :  
```bash
mkdocs serve

Pour compiler le prototype :

cd src/main/java
javac prototype/**/*.java 
java prototype.Main


cd /Users/zerroug/Desktop/genie-logiciel-lafontant/IFT2255-Devoir1
mvn clean compile

et simplement lancer directement ton programme avec la commande suivante :
▶ Pour lancer l'application console
mvn exec:java -Dexec.mainClass="prototype.Main"

▶ Pour lancer le serveur 

