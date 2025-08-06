public class Etudiant {
    private String nom;
    private String prenom;
    private double[] notes;
    private double moyenne;

    // Constructeur
    public Etudiant(String nom, String prenom, double[] notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
        calculerMoyenne();
    }

    // Calcul de la moyenne
    private void calculerMoyenne() {
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        this.moyenne = somme / notes.length;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public String toCSVLine() {
        return nom + "," + prenom + "," + String.format("%.2f", moyenne);
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " - Moyenne : " + String.format("%.2f", moyenne);
    }
}