package serveces;
import models.Livre;
import java.sql.*;

public class LivreService {
    private Connection connection;

    public LivreService() {  //constructor
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas22", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ajouterLivre(Livre livre,int id) {
        try  {
            String query = "INSERT INTO livres (titre,numero_ISBN,quantity,id_auteur) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getNumeroISBN());
            statement.setInt(3, livre.getQuantity());
            statement.setInt(4, id);
            statement.executeUpdate();

            System.out.println("livre a été créé avec succés");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLivre(Livre livre) {
        try  {

                String query = "UPDATE livres SET titre = ?,numero_ISBN=?,quantity=? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, livre.getTitre());
                statement.setString(2, livre.getNumeroISBN());
                statement.setInt(3, livre.getQuantity());
                statement.setInt(4, livre.getIdLivre());
                statement.executeUpdate();

                System.out.println("livre a été modifié avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteLivre(int id) {
        try  {
                String query = "DELETE FROM livres WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1,id);
                statement.executeUpdate();

                System.out.println("livre a été supprimé avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherLivresDisponibles(){
        try{
            System.out.println();
            System.out.println();
            String query = "SELECT * FROM livres INNER JOIN auteurs ON livres.id_auteur = auteurs.id;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet livresSet=statement.executeQuery();
            System.out.println("les livres disponibles:");
            System.out.println();
            int i=0;
            while (livresSet.next()){
                i++;
                String titre = livresSet.getString("titre");
                String numero_ISBN = livresSet.getString("numero_ISBN");
                int quantity = livresSet.getInt("quantity");
                String auteur = livresSet.getString("nom");

                System.out.println("livre "+i+": ");
                System.out.println("titre: "+titre);
                System.out.println("auteur: "+auteur);
                System.out.println("numero ISBN: "+numero_ISBN);
                System.out.println("quanitiy: "+quantity);
                System.out.println("--------------------------");
            }
            if(i==0) {
                System.out.println("il n'y a pas de livres disbonibles");
            }
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherLivresEmpruntesEtPerdus(String statut){
        try{
            String query = "SELECT *,COUNT(id_livre) FROM livres " +
                    "INNER JOIN auteurs ON auteurs.id = livres.id_auteur " +
                    "INNER JOIN reservations ON livres.id = reservations.id_livre " +
                    "AND statut=? GROUP BY reservations.id_livre;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,statut);
            ResultSet livresSet=statement.executeQuery();
            System.out.println("les livres "+statut+"s:");
            System.out.println();
            int i=0;
            while (livresSet.next()){
                i++;
                String titre = livresSet.getString("titre");
                String numero_ISBN = livresSet.getString("numero_ISBN");
                String quantity = livresSet.getString("COUNT(id_livre)");
                String auteur = livresSet.getString("nom");

                System.out.println("livre "+i+": ");
                System.out.println("titre: "+titre);
                System.out.println("auteur: "+auteur);
                System.out.println("numero ISBN: "+numero_ISBN);
                System.out.println("quanitiy: "+quantity);
                System.out.println("--------------------------");
            }
            if(i==0) {
                System.out.println("il n'y a pas de livresn"+statut+"s");
            }
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void chercherLivre(String choix){
        try{
            String query = "SELECT * FROM livres INNER JOIN auteurs ON livres.id_auteur = auteurs.id AND (auteurs.nom=? OR livres.titre=?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, choix);
            statement.setString(2, choix);
            ResultSet livreSet=statement.executeQuery();
            int i=0;
            while (livreSet.next()){
                i++;
                String titre = livreSet.getString("titre");
                String numero_ISBN = livreSet.getString("numero_ISBN");
                String quantity = livreSet.getString("quantity");
                String auteur = livreSet.getString("nom");

                System.out.println("titre: "+titre);
                System.out.println("auteur: "+auteur);
                System.out.println("numero ISBN: "+numero_ISBN);
                System.out.println("quantité: "+quantity);

                System.out.println("--------------------------");
            }
            if(i==0) {
                System.out.println("ce livre n'existe pas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int checkId(int id){
        try{
            String checkQuery = "SELECT id FROM livres WHERE id = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, id);
            ResultSet checkResult = checkStatement.executeQuery();
            if(checkResult.next()) {
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int checkNumeroISBN(String numeroISBN){
        try{
            String checkQuery = "SELECT id FROM livres WHERE numero_ISBN= ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, numeroISBN);
            ResultSet checkResult = checkStatement.executeQuery();
            if(checkResult.next()) {
                return checkResult.getInt("id");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int checkQuantity(int id){
        try{
            String checkQuery = "SELECT quantity FROM livres WHERE id= ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, id);
            ResultSet checkResult = checkStatement.executeQuery();
            if(checkResult.next()) {
                return checkResult.getInt("quantity");
            }else{
                return -2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void decrementQuantity(int id) {
        try {
            String query = "UPDATE livres SET quantity = quantity - 1 WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void incrementQuantity(int id) {
        try {
            String query = "UPDATE livres SET quantity = quantity +1 WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
