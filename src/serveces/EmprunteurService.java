package serveces;

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
                return 1;
            }
            return i;

        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

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

    public int ajouterEmprunteur(String choix,Emprunteur emprunteur){
        try(){
            String query="INSERT INTO emprunteurs (nom_emprunteur,code_emprunteur) VALUES (?, ?)";
            PreparedStatement statement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,emprunteur.getNomEmprunteur());
            statement.setString(2,emprunteur.getCodeEmprunteur());
            statement.executeUpdate();
            System.out.println("l'emprunteur a été ajouté avec succés.")

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int idEmprunteur=0;
            if (generatedKeys.next()) {
                idEmprunteur = generatedKeys.getInt(1);
            } else {
                System.out.println("Failed to retrieve the generated ID.");
            }

            return idEmprunteur;
        }catch(SQLException e){
            e.prantStackTrace();
            return -1;
        }
    }

}
