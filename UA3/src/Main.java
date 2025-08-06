import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fichierEntree = "notes_etudiants.csv";
        String fichierSortie = "resultats_etudiants.csv";

        // Lecture du fichier CSV
        List<Etudiant> etudiants = GestionEtudiant.lireCSV(fichierEntree);

        // Tri par moyenne décroissante
        GestionEtudiant.trierParMoyenne(etudiants);

        // Affichage dans la console
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

        // Sauvegarde dans un nouveau fichier CSV
        GestionEtudiant.sauvegarderResultats(fichierSortie, etudiants);
    }
}