import java.io.*;
import java.util.*;
public class GestionEtudiant {

    // Méthode pour lire le fichier CSV et créer une liste d'étudiants
    public static List<Etudiant> lireCSV(String cheminFichier) {
        List<Etudiant> liste = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            boolean premiereLigne = true;

            while ((ligne = br.readLine()) != null) {
                if (premiereLigne) {
                    premiereLigne = false; // ignorer l'entête
                    continue;
                }

                String[] parties = ligne.trim().split(",");

                if (parties.length < 3) {
                    System.out.println("Ligne ignorée (pas assez de colonnes) : " + ligne);
                    continue;
                }

                String nom = parties[0].trim();
                String prenom = parties[1].trim();
                double[] notes = new double[parties.length - 2];

                for (int i = 2; i < parties.length; i++) {
                    try {
                        notes[i - 2] = Double.parseDouble(parties[i].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Note invalide à la ligne : " + ligne);
                        notes[i - 2] = 0;
                    }
                }

                Etudiant e = new Etudiant(nom, prenom, notes);
                liste.add(e);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return liste;
    }

    // Méthode pour trier les étudiants par moyenne décroissante
    public static void trierParMoyenne(List<Etudiant> liste) {
        liste.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));
    }

    // Méthode pour sauvegarder les résultats dans un fichier CSV
    public static void sauvegarderResultats(String cheminFichier, List<Etudiant> liste) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(cheminFichier))) {
            pw.println("Nom,Prénom,Moyenne");
            for (Etudiant e : liste) {
                pw.println(e.toCSVLine());
            }
            System.out.println("Fichier de résultats sauvegardé : " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur d'écriture du fichier : " + e.getMessage());
        }
    }
}