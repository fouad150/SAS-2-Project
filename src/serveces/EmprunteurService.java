package serveces;
import models.Emprunteur;
import java.sql.*;

public class EmprunteurService {
    private Connection connection;

    public EmprunteurService() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sas2", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int checkEmprunteur(int codeEmprunteur){
        try{
            String checkQuery="SELECT id FROM auteurs WHERE code_empruntur=?";
            PreparedStatement checkStatement=connection.prepareStatement(checkQuery);
            checkStatement.setInt(1,codeEmprunteur);
            ResultSet checkResult=checkStatement.executeQuery();

            int i=0;
            if (checkResult.next()) {
                return checkResult.getInt("id");
            }
            return i;

        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }


    public int ajouterEmprunteur(String choix,Emprunteur emprunteur){
        try{
            String query="INSERT INTO emprunteurs (nom_emprunteur,code_emprunteur) VALUES (?, ?)";
            PreparedStatement statement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,emprunteur.getNomEmprunteur());
            statement.setInt(2,emprunteur.getCodeEmprunteur());
            statement.executeUpdate();


            ResultSet generatedKeys = statement.getGeneratedKeys();
            int idEmprunteur=0;
            if (generatedKeys.next()) {
                idEmprunteur = generatedKeys.getInt(1);
            } else {
                System.out.println("Failed to retrieve the generated ID.");
            }

            return idEmprunteur;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}
