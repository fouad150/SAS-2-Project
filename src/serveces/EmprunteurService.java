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
}
