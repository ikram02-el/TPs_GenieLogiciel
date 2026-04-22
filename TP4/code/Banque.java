// ============================================================
//  Exercice 1.3 — Système de gestion des comptes bancaires
//  Concepts : Héritage, Encapsulation, Polymorphisme
// ============================================================

// 1. Classe de base CompteBancaire
class CompteBancaire {
    private String numeroCompte; // Encapsulation
    private double solde;

    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde        = soldeInitial;
    }

    // Getters
    public String getNumeroCompte() { return numeroCompte; }
    public double getSolde()        { return solde; }

    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " € effectué. Solde : " + solde + " €");
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    // Méthode pour retirer de l'argent avec vérification du solde
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant de retrait invalide.");
        } else if (montant > solde) {
            System.out.println("Solde insuffisant. Solde actuel : " + solde + " €");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant + " € effectué. Solde : " + solde + " €");
        }
    }

    public void afficherSolde() {
        System.out.println("Compte [" + numeroCompte + "] — Solde : " + solde + " €");
    }
}

// 2. Classe CompteCourant héritant de CompteBancaire
class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double soldeInitial, double decouvertAutorise) {
        super(numeroCompte, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Surcharge : retrait avec découvert autorisé
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide.");
        } else if (montant > getSolde() + decouvertAutorise) {
            System.out.println("Dépassement du découvert autorisé (" + decouvertAutorise + " €).");
        } else {
            System.out.println("Retrait de " + montant + " € (découvert autorisé : "
                + decouvertAutorise + " €). Solde : " + (getSolde() - montant) + " €");
            super.retirer(montant);
        }
    }
}

// 3. Classe CompteEpargne héritant de CompteBancaire
class CompteEpargne extends CompteBancaire {

    public CompteEpargne(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }

    // Méthode pour calculer et ajouter les intérêts
    public void calculerInterets(double taux) {
        double interets = getSolde() * taux / 100;
        deposer(interets);
        System.out.println("Intérêts calculés (" + taux + "%) : +" + interets
            + " €. Nouveau solde : " + getSolde() + " €");
    }
}

// 4. Classe principale Banque
public class Banque {
    public static void main(String[] args) {

        System.out.println("====== COMPTE COURANT ======");
        CompteCourant cc = new CompteCourant("CC-001", 1000.0, 500.0);
        cc.afficherSolde();
        cc.deposer(200.0);
        cc.retirer(300.0);
        cc.retirer(1500.0); // Test dépassement découvert
        cc.afficherSolde();

        System.out.println("\n====== COMPTE ÉPARGNE ======");
        CompteEpargne ce = new CompteEpargne("CE-001", 5000.0);
        ce.afficherSolde();
        ce.deposer(1000.0);
        ce.retirer(200.0);
        ce.calculerInterets(3.5); // Taux d'intérêt de 3.5%
        ce.afficherSolde();
    }
}
