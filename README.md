1-Class : Etudiant.java

-Rôle : Représente un étudiant avec son nom, prénom, ses notes et sa moyenne.

Attributs :
  - `nom` : Nom de l'étudiant.
  - `prenom` : Prénom de l'étudiant.
  - `notes` : Tableau contenant les notes obtenues.
  - `moyenne` : Moyenne calculée à partir des notes.
    
Constructeur :
  - Permet d'initialiser le nom, le prénom et les notes de l'étudiant.
  - La moyenne est calculée dès la création de l'objet.

Méthodes principales :
  - `calculerMoyenne()` : Calcule la moyenne des notes.
  - `getNom()`, `getPrenom()`, `getNotes()`, `getMoyenne()` : Accesseurs (Getters).
  - `toString()` : Retourne une chaîne décrivant l'étudiant et sa moyenne.


2-Class : GestionEtudiant.java

-Rôle : Gère la lecture, le traitement et l'écriture des données des étudiants.

Importations :
  - `java.io.*` : Pour lire/écrire dans des fichiers.
  - `java.util.*` : Pour utiliser les listes et autres structures de données.

Méthodes principales :
  - `lireCSV(String cheminFichier)` :
    - Lit un fichier CSV ligne par ligne.
    - Sépare chaque ligne par des virgules.
    - Convertit les notes en `double[]`.
    - Crée un objet `Etudiant` pour chaque ligne et l'ajoute à une liste.
  - `trierParMoyenne(List<Etudiant> liste)` :
    - Trie la liste des étudiants par moyenne décroissante.
  - `ecrireCSV(List<Etudiant> liste, String cheminFichier)` :
    - Écrit les informations des étudiants dans un fichier CSV de sortie.


3-Class : Main.java

-Rôle : Point d'entrée du programme.

Fonctionnement :
  1. Définit les noms des fichiers CSV d'entrée et de sortie.
  2. Appelle `GestionEtudiant.lireCSV()` pour charger les données.
  3. Trie les étudiants par moyenne.
  4. Écrit les résultats dans un nouveau fichier CSV avec `GestionEtudiant.ecrireCSV()`.
  5. Affiche les résultats dans la console pour vérification.

