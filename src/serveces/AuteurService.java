package serveces;
import models.Auteur;

import models.Livre;

import java.sql.*;

public class AuteurService {
    private Connection connection;

    public AuteurService() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas22", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int checkAuteur(String nomAuteur){
        try{
            String checkQuery="SELECT id FROM auteurs WHERE nom=?";
            PreparedStatement checkStatement=connection.prepareStatement(checkQuery);
            checkStatement.setString(1,nomAuteur);
            ResultSet checkResult=checkStatement.executeQuery();

            int id=0;
            if (checkResult.next()) {
                id = checkResult.getInt("id");
            }
            return id;

        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

      

    public int ajouterAuteur(Auteur auteur) {
        try  {
            String query = "INSERT INTO auteurs (nom,nationalite) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, auteur.getNomAuteur());
            statement.setString(2, auteur.getNotionaliteAuteur());
            statement.executeUpdate();

            System.out.println("l'auteur a été ajouté avce succés, complétez les informations du livre:");

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int idAuteur=0;
            if (generatedKeys.next()) {
                idAuteur = generatedKeys.getInt(1); // Use index 1 to retrieve the generated ID
            } else {
                System.out.println("Failed to retrieve the generated ID.");
            }

            return idAuteur;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
