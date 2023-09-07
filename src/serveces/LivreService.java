package serveces;
import models.Livre;
import java.sql.*;

public class LivreService {
    private Connection connection;

    public LivreService() {  //constructor
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas2", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ajouterLivre(Livre livre,int id) {
        try  {
            String query = "INSERT INTO livres (titre,numero_ISBN,quantity,id_auteur) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, livre.getTitre());
            statement.setInt(2, livre.getNumeroISBN());
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
                statement.setInt(2, livre.getNumeroISBN());
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


}
