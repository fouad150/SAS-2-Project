import java.util.Scanner;

import classes.LivreClass;
import modals.Livre;

public class Main {
    private static LivreClass livreClass = new LivreClass();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ajouterLivre(scanner);
    }


    public static void ajouterLivre(Scanner scanner) {

            System.out.print("entrer le titre du livre: ");
            String titre = scanner.nextLine();
            System.out.print("entrer l'auteur: ");
            String auteur = scanner.nextLine();
            System.out.print("entrer le numero ISBN: ");
            String input1 = scanner.nextLine();
            int numeroISBN=Integer.parseInt(input1);
            System.out.print("entrer la quantity: ");
            String input2 = scanner.nextLine();
            int quantity=Integer.parseInt(input2);

            Livre livre=new Livre(titre,auteur,numeroISBN,quantity);
            livreClass.ajouterLivre(livre);
            System.out.println("livre créé avec succés");

    }



}
