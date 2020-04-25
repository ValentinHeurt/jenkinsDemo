import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;


public class Statut {



    public static void main(String[] args) {
        Scanner saisieUtilisateur = new Scanner(System.in); 
        System.out.println("Veuillez saisir votre id pour modifier le statut :");
        int id = saisieUtilisateur.nextInt(); 
        System.out.println("Veuillez saisir votre nouveau statut :");
        String nomStatut = saisieUtilisateur.next(); 

        try { 
            String strClassName = "com.mysql.cj.jdbc.Driver";
            String dbName= "dbjdbc"; 
            String login= "root"; 
            String motdepasse= ""; 
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";



            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddUser = conn.createStatement();
            stAddUser.executeUpdate("update Statut set nom='" + nomStatut + "' where id=" + id);

            conn.close();
            }
            catch(ClassNotFoundException e) {
                System.err.println("Driver non chargé !");  e.printStackTrace();
            } catch(SQLException e) {
                System.err.println("Autre erreur !");  e.printStackTrace();
            }

    }
}