package classes;
import modals.Livre;
import java.sql.*;

public class LivreClass {
    private Connection connection;

    public LivreClass() {  //constructor
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas2", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ajouterLivre(Livre livre) {
        try  {
            String query = "INSERT INTO livres (titre, auteur, numero_ISBN,quantity) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, livre.getTitre());
            statement.setString(2, livre.getAuteur());
            statement.setInt(3, livre.getNumeroISBN());
            statement.setInt(4, livre.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
