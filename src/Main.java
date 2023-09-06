import java.util.Scanner;

import serveces.LivreService;
import models.Livre;

public class Main {
    private static LivreService livreService = new LivreService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ajouterLivre(scanner);
        //updateLivre(scanner);
        deleteLivre(scanner);
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
            livreService.ajouterLivre(livre);
    }

    public static void updateLivre(Scanner scanner) {

        System.out.print("entrer l'id de livre:");
        int id=Integer.parseInt(scanner.nextLine());

        if(livreService.checkId(id)==1) {

            System.out.print("entrer le titre du livre: ");
            String titre = scanner.nextLine();
            System.out.print("entrer l'auteur: ");
            String auteur = scanner.nextLine();
            System.out.print("entrer le numero ISBN: ");
            String input1 = scanner.nextLine();
            int numeroISBN = Integer.parseInt(input1);
            System.out.print("entrer la quantity: ");
            String input2 = scanner.nextLine();
            int quantity = Integer.parseInt(input2);

            Livre livre = new Livre(id, titre, auteur, numeroISBN, quantity);
            livreService.updateLivre(livre);
        }else{
            System.out.println("le livre est introubale");
        }
    }

    public static void deleteLivre(Scanner scanner){
        System.out.print("entrer l'id de livre pour le supprimer: ");
        int id=scanner.nextInt();
        if(livreService.checkId(id)==1) {
        livreService.deleteLivre(id);
        }else{
            System.out.println("le livre est introubale");
        }
    }



}
