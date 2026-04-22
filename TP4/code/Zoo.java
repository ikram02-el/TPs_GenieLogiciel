// ============================================================
//  Exercice 1.1 — Système de gestion d'animaux dans un zoo
//  Concepts : Abstraction, Héritage, Polymorphisme, Encapsulation
// ============================================================

// 1. Classe abstraite Animal
abstract class Animal {
    private String nom; // Encapsulation : attribut privé

    public Animal(String nom) {
        this.nom = nom;
    }

    // Getter (Encapsulation)
    public String getNom() {
        return nom;
    }

    // Méthode abstraite (Abstraction) : chaque sous-classe doit l'implémenter
    public abstract void faireDuBruit();
}

// 2. Classe Mammifere héritant d'Animal (Héritage)
class Mammifere extends Animal {
    public Mammifere(String nom) {
        super(nom); // Appel au constructeur de la classe parente
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " grogne.");
    }
}

// 3. Classe Oiseau héritant d'Animal (Héritage)
class Oiseau extends Animal {
    public Oiseau(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " chante.");
    }

    // Question 5 : Méthode voler() complétée
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

// 4. Classe principale avec polymorphisme
public class Zoo {
    public static void main(String[] args) {

        // Polymorphisme : référence de type Animal
        Animal tigre     = new Mammifere("Tigre");
        Animal perroquet = new Oiseau("Perroquet");

        tigre.faireDuBruit();     // Sortie : Tigre grogne.
        perroquet.faireDuBruit(); // Sortie : Perroquet chante.

        // Question 6 : utiliser voler() — cast en Oiseau
        Oiseau perroquetOiseau = new Oiseau("Perroquet");
        perroquetOiseau.faireDuBruit(); // Sortie : Perroquet chante.
        perroquetOiseau.voler();        // Sortie : L'oiseau vole.
    }
}
