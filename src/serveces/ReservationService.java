package serveces;
import models.Reservation;
import java.sql.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ReservationService {
    private Connection connection;

    public ReservationService() {  //constructor
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas22", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ajouterReservation(Reservation reservation,int idLivre, int idEmprunteur) {
        try  {
            String query = "INSERT INTO Reservations (date_emprunt,date_recuperation,statut,id_livre,id_emprunteur) VALUES (?, ?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, reservation.getDateEmprunt());
            statement.setString(2, reservation.getDateRecuperation());
            statement.setString(3, reservation.getStatut());
            statement.setInt(4, idLivre);
            statement.setInt(5, idEmprunteur);
            statement.executeUpdate();

            System.out.println("l'operation accomplie avec succés.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String parseDateEmprunt(){
        Scanner scanner = new Scanner(System.in);
        String dateEmprunt="";
        while(true){
            System.out.print("entrez la date d'emprunt (YYYY-MM-DD):");
            dateEmprunt=scanner.nextLine();
            try {
                LocalDate parsedDate = LocalDate.parse(dateEmprunt);
                break;
            } catch (DateTimeParseException e) {
                //System.out.println("Parsing failed. Invalid date format.");
                //e.printStackTrace();
            }
        }
        return dateEmprunt;
        
    }

     public String parseDateRecuperation(){
         String dateRecuperation="";
         Scanner scanner = new Scanner(System.in);
         while(true){
            System.out.print("entrez la date de recuperation (YYYY-MM-DD):");
            dateRecuperation=scanner.nextLine();
            try {
                LocalDate parsedDate = LocalDate.parse(dateRecuperation);
                break;
            } catch (DateTimeParseException e) {
                //System.out.println("Parsing failed. Invalid date format.");
                //e.printStackTrace();
            }
        }
        return dateRecuperation;
        
    }

    public int supprimerReservation(int idEmprunteur, int idLivre){
        try  {
            String query = "DELETE FROM reservations WHERE id_emprunteur=? AND id_livre=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,idEmprunteur);
            statement.setInt(2,idLivre);
            int rowUpdated = statement.executeUpdate();

            if(rowUpdated>0){
                return 1;
            }
                return 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

     public int livrePerdu(int idEmprunteur, int idLivre){
        try  {
            String query = "UPDATE `reservations` SET `statut`='perdu' WHERE id_emprunteur=? AND id_livre=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,idEmprunteur);
            statement.setInt(2,idLivre);
            int rowUpdated = statement.executeUpdate();
            if(rowUpdated>0){
                return 1;
            }
                return 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
