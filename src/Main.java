import java.util.Scanner;

import serveces.LivreService;
import serveces.AuteurService;
import models.Livre;
import models.Auteur;

public class Main {
    private static LivreService livreService = new LivreService();
    private static AuteurService auteurService=new AuteurService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ajouterLivre(scanner);
        //updateLivre(scanner);
        //deleteLivre(scanner);
        //afficherLivresDisponibles(scanner);
        chercherLivre(scanner);
    }


    public static void ajouterLivre(Scanner scanner) {

            System.out.print("entrez le titre du livre: ");
            String titre = scanner.nextLine();
            System.out.print("entrez le nom de l'auteur: ");
            String auteurNom = scanner.nextLine();
            int id=auteurService.checkAuteur(auteurNom);
            if(id>=1){
                System.out.print("entrez le numero ISBN: ");
                String input1 = scanner.nextLine();
                int numeroISBN=Integer.parseInt(input1);
                System.out.print("entrez la quantity: ");
                String input2 = scanner.nextLine();
                int quantity=Integer.parseInt(input2);

                Livre livre=new Livre(titre,numeroISBN,quantity);
                livreService.ajouterLivre(livre,id);
            }else if(id==0){
                int[] arr= ajouterAuteur(scanner,auteurNom);
                int choix=arr[0];
                int idAuteur=arr[1];
                if(choix==1){
                    System.out.print("entrez le numero ISBN: ");
                    String input1 = scanner.nextLine();
                    int numeroISBN=Integer.parseInt(input1);
                    System.out.print("entrez la quantity: ");
                    String input2 = scanner.nextLine();
                    int quantity=Integer.parseInt(input2);

                    Livre livre=new Livre(titre,numeroISBN,quantity);
                    livreService.ajouterLivre(livre,idAuteur);
                }
            }

    }

    public static void updateLivre(Scanner scanner) {

        System.out.print("entrez l'id de livre:");
        int id=Integer.parseInt(scanner.nextLine());

        if(livreService.checkId(id)==1) {

            System.out.print("entrez le titre du livre: ");
            String titre = scanner.nextLine();
            //System.out.print("entrer le nom de l'auteur: ");
            //String auteurNom = scanner.nextLine();
            System.out.print("entrez le numero ISBN: ");
            String input1 = scanner.nextLine();
            int numeroISBN = Integer.parseInt(input1);
            System.out.print("entrez la quantity: ");
            String input2 = scanner.nextLine();
            int quantity = Integer.parseInt(input2);

            Livre livre = new Livre(id, titre, numeroISBN, quantity);
            livreService.updateLivre(livre);


        }else{
            System.out.println("le livre est introubale");
        }
    }

    public static void deleteLivre(Scanner scanner){
        System.out.print("entrez l'id de livre pour le supprimer: ");
        int id=scanner.nextInt();
        if(livreService.checkId(id)==1) {
        livreService.deleteLivre(id);
        }else{
            System.out.println("le livre est introubale");
        }
    }

    public static void afficherLivresDisponibles(Scanner scanner){
        livreService.afficherLivresDisponibles();
    }

    public static void chercherLivre(Scanner scanner){
        System.out.print("entrez l'auteur ou le titre de livre: ");
        String choix=scanner.nextLine();
        livreService.chercherLivre(choix);
    }

    public static int[] ajouterAuteur(Scanner scanner,String nom){
        System.out.println("cet auteur n'existe pas, veuillez l'ajouter: oui/no");
        String choix=scanner.nextLine();
        int choixNombre=0;
        int idAuteur=0;
        if(choix.equals("oui")){
            System.out.println("entrez la nationalité: ");
            String nationalite=scanner.nextLine();
            Auteur auteur=new Auteur(nom,nationalite);
            idAuteur=auteurService.ajouterAuteur(auteur);
            choixNombre=1;
        }
        return new int[]{choixNombre,idAuteur};
    }



}
