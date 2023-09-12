import java.util.Scanner;

import serveces.LivreService;
import serveces.AuteurService;
import serveces.EmprunteurService;
import serveces.ReservationService;
import models.Livre;
import models.Auteur;
import models.Emprunteur;
import models.Reservation;

public class Main {
    private static LivreService livreService = new LivreService();
    private static AuteurService auteurService=new AuteurService();
    private static EmprunteurService emprunteurService=new EmprunteurService();
    private static ReservationService reservationService=new ReservationService();



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix=0;
        do{
            System.out.println();
            System.out.println();
            System.out.println("entrez 1 pour ajouter un livre.");
            System.out.println("entrez 2 pour modifier un livre.");
            System.out.println("entrez 3 pour supprimer un livre.");
            System.out.println("entrez 4 pour afficher les livres disponible.");
            System.out.println("entrez 5 pour chercher un livre.");
            System.out.println("entrez 6 pour emprunter un livre.");
            System.out.println("entrez 7 pour retourner un livre.");
            System.out.println("entrez 8 pour déclarer le perte d'un livre.");
            System.out.println("entrez 9 pour afficher le raport.");
            System.out.println("entrez 0 pour arrêter le programme.");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouterLivre(scanner);
                    break;
                case 2:
                    updateLivre(scanner);
                    break;
                case 3:
                    deleteLivre(scanner);
                    break;
                case 4:
                    afficherLivresDisponibles(scanner);
                    break;
                case 5:
                    chercherLivre(scanner);
                    break;
                case 6:
                    emprunter(scanner);
                    break;
                case 7:
                    retourner(scanner);
                    break;
                case 8:
                    livrePerdu(scanner);
                    break;
                case 9:
                    afficherRaport(scanner);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }while(choix>0);
    }






    public static void ajouterLivre(Scanner scanner) {

            System.out.print("entrez le titre du livre: ");
            String titre = scanner.nextLine();
            System.out.print("entrez le nom de l'auteur: ");
            String auteurNom = scanner.nextLine();
            int id=auteurService.checkAuteur(auteurNom);
            if(id>=1){
                System.out.print("entrez le numero ISBN: ");
                String numeroISBN=scanner.nextLine();
                int livreExiste=livreService.checkNumeroISBN(numeroISBN);
                if(livreExiste==0){
                    System.out.print("entrez la quantity: ");
                    String input2 = scanner.nextLine();
                    int quantity=Integer.parseInt(input2);

                    Livre livre=new Livre(titre,numeroISBN,quantity);
                    livreService.ajouterLivre(livre,id);
                }else if(livreExiste>0){
                    System.out.println("ce numéro ISBN déja existe.");
                }

            }else if(id==0){
                int[] arr= ajouterAuteur(scanner,auteurNom);
                int choix=arr[0];
                int idAuteur=arr[1];
                if(choix==1){
                    System.out.print("entrez le numero ISBN: ");
                    String numeroISBN=scanner.nextLine();
                    int livreExiste=livreService.checkNumeroISBN(numeroISBN);
                    if(livreExiste==0){
                    System.out.print("entrez la quantity: ");
                    String input2 = scanner.nextLine();
                    int quantity=Integer.parseInt(input2);

                    Livre livre=new Livre(titre,numeroISBN,quantity);
                    livreService.ajouterLivre(livre,idAuteur);
                    }else if(livreExiste>0){
                        System.out.println("ce numéro ISBN déja existe.");
                    }
                }
            }

    }

    public static void updateLivre(Scanner scanner) {

        System.out.print("entrez numéro ISBN de livre pour modifier:");
        String numeroISBN=scanner.nextLine();
        int livreExiste=livreService.checkNumeroISBN(numeroISBN);
        if(livreExiste>0) {
            int id=livreExiste;
            System.out.print("entrez le titre du livre: ");
            String titre = scanner.nextLine();
            System.out.print("rentrez ou changer le numero ISBN: ");
            String nouveauNumeroISBN=scanner.nextLine();
            System.out.print("entrez la quantity: ");
            int quantity =scanner.nextInt();

            Livre livre = new Livre(id, titre, nouveauNumeroISBN, quantity);
            livreService.updateLivre(livre);


        }else if(livreExiste==0){
            System.out.println("le livre est introubale");
        }
    }

    public static void deleteLivre(Scanner scanner){
        System.out.print("entrez numéro ISBN de livre pour supprimer:");
        String numeroISBN=scanner.nextLine();
        int livreExiste=livreService.checkNumeroISBN(numeroISBN);
        if(livreExiste>0) {
            int id=livreExiste;
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
            System.out.print("entrez la nationalité: ");
            String nationalite=scanner.nextLine();
            Auteur auteur=new Auteur(nom,nationalite);
            idAuteur=auteurService.ajouterAuteur(auteur);
            choixNombre=1;
        }
        return new int[]{choixNombre,idAuteur};
    }

    public static void emprunter(Scanner scanner){
        System.out.print("entrer le code de l'emprunteur: ");
        int codeEmprunteur =scanner.nextInt();
        scanner.nextLine();//
        int emprunteurExiste=emprunteurService.checkEmprunteur(codeEmprunteur);
        if(emprunteurExiste==0){
            System.out.println("cet emprunteur n'exsite pas , voulez-vous l'ajouter: oui/no");
            String choix=scanner.nextLine();

            if(choix.equals("oui")){
                System.out.print("entrez le nom de l'emprunteur: ");
                String nomEmprunteur=scanner.nextLine();
                Emprunteur emprunteur=new Emprunteur(nomEmprunteur,codeEmprunteur);
                int idEmprunteur=emprunteurService.ajouterEmprunteur(choix,emprunteur);
                if(idEmprunteur>0){
                    System.out.println("l'emprunteur a été ajouté avec succés. complétez l'operation d'emprunt:");
                    System.out.print("entrez l'ESBN de livre:");
                    String numeroISBN=scanner.nextLine();
                    int livreExiste=livreService.checkNumeroISBN(numeroISBN);
                    int idLivre=livreExiste;
                    if(livreExiste==0){
                        System.out.println("ce livre n'exsite pas.");
        
                    }else if(livreExiste>0){
                        int quantity=livreService.checkQuantity(idLivre);
                        if(quantity>0){
                            livreService.decrementQuantity(idLivre);
                            String dateEmprunt= reservationService.parseDateEmprunt();
                            String dateRecuperation= reservationService.parseDateRecuperation();
                            String statut="emprunté";
                            Reservation reservation=new Reservation(dateEmprunt,dateRecuperation,statut);
                            reservationService.ajouterReservation(reservation,idLivre,idEmprunteur);
                        }else{
                            System.out.println("quantité est terminée");
                        }

                    }

                }else if(idEmprunteur==0){
                    System.out.println("une erreur s'est produite, réessayez");
                }
            }

        }else if(emprunteurExiste>0){
            int idEmprunteur=emprunteurExiste;
            System.out.print("entrez l'ESBN de livre:");
            String numeroISBN=scanner.nextLine();
            int livreExiste=livreService.checkNumeroISBN(numeroISBN);
            int idLivre=livreExiste;
            if(livreExiste==0){
                System.out.println("ce livre n'exsite pas.");

            }else if(livreExiste>0){
                int quantity=livreService.checkQuantity(idLivre);
                if(quantity>0){
                    livreService.decrementQuantity(idLivre);
                    String dateEmprunt= reservationService.parseDateEmprunt();
                    String dateRecuperation= reservationService.parseDateRecuperation();
                    String statut="disponible";
                    Reservation reservation=new Reservation(dateEmprunt,dateRecuperation,statut);
                    reservationService.ajouterReservation(reservation,idLivre,idEmprunteur);
                }else{
                    System.out.println("quantité est terminée");
                }

            }
        }

    }

    public static void retourner(Scanner scanner){
        System.out.println("entrez numéro ISBN de livre:");
        String numeroISBN=scanner.nextLine();
        int livreExiste=livreService.checkNumeroISBN(numeroISBN);
        int idLivre=livreExiste;
        if(livreExiste==0){
            System.out.println("ce livre n'exsite pas.");
        }else if(livreExiste>0){
            System.out.println("entrer le code de l'emprunteur:");
            int codeEmprunteur =scanner.nextInt();
            int emprunteurExiste=emprunteurService.checkEmprunteur(codeEmprunteur);
            if(emprunteurExiste==0){
                System.out.println("cet emprunteur n'exsite pas.");
            }else if(emprunteurExiste>0){
                int idEmprunteur=emprunteurExiste;
                int reservationExiste=reservationService.supprimerReservation(idEmprunteur,idLivre);
                if(reservationExiste==0){
                    System.out.println("cet utilisateur n'a pas emprunté ce livre.");
                }else if(reservationExiste==1){
                    livreService.incrementQuantity(idLivre);
                    System.out.println("l'operation accomplie avec succés.");
                }
            }
        }
    }

    public static void livrePerdu(Scanner scanner){
        System.out.println("entrez numéro ISBN de livre:");
        String numeroISBN=scanner.nextLine();
        int livreExiste=livreService.checkNumeroISBN(numeroISBN);
        int idLivre=livreExiste;
        if(livreExiste==0){
            System.out.println("ce livre n'exsite pas.");
        }else if(livreExiste>0){
            System.out.println("entrer le code de l'emprunteur");
            int codeEmprunteur =scanner.nextInt();
            int emprunteurExiste=emprunteurService.checkEmprunteur(codeEmprunteur);
            if(emprunteurExiste==0){
                System.out.println("cet emprunteur n'exsite pas");
            }else if(emprunteurExiste>0){
                int idEmprunteur=emprunteurExiste;
                int reservationExiste=reservationService.livrePerdu(idEmprunteur,idLivre);
                if(reservationExiste==0){
                    System.out.println("cet utilisateur n'a pas emprunté ce livre.");
                }else if(reservationExiste==1){
                    System.out.println("statut du livre a changé avec succés.");
                }
            }
        }
    }

    public static void afficherRaport(Scanner scanner){
        livreService.afficherLivresDisponibles();
        livreService.afficherLivresEmpruntesEtPerdus("emprunté");
        livreService.afficherLivresEmpruntesEtPerdus("perdu");
    }

}
