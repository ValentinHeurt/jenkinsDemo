package tpJDBC;

import java.sql.*;
import java.util.ArrayList;

import tpJDBC.*;

public class AccesDAO {

	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.jdbc.Driver";
		String dbName= "tpJDBC"; 
		String login= "root"; 
		String motdepasse= "root"; 
		String strUrl = "jdbc:mysql://localhost:3306/" +  dbName + "?useSSL=false";

		Class.forName(driver);
		System.out.println("Debug : Driver OK");
		Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
		System.out.println("Debug : Connection OK");

	    return conn;
	}
	
	
	
	public boolean addAcces(Acces a) {
		boolean flag = false;
		try { 
			Connection conn = getConnection();
			String req = "INSERT INTO acces (prenom,login,password,statut,age) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(req);  
			pstmt.setString(1,a.getPrenom());
			pstmt.setString(2,a.getLogin());
			pstmt.setString(3,a.getPassword());
			pstmt.setString(4,a.getStatut());
			pstmt.setInt(5,a.getAge());
			pstmt.executeUpdate();
			System.out.println("Debug : Insertion");
			pstmt.close();
			conn.close();
			flag = true;
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}
		return flag;
	}
	
	public ArrayList<Acces> getAllAcces(){
		ArrayList<Acces> list = new ArrayList<Acces>();
		try { 
			
			Connection conn = getConnection();
			Statement stUsers = conn.createStatement();  

			ResultSet rsUsers = stUsers.executeQuery("select * from Acces");  
			while(rsUsers.next()) {
				list.add(new Acces(rsUsers.getInt(1),rsUsers.getString(2),rsUsers.getString(3),rsUsers.getString(4),rsUsers.getString(5),rsUsers.getInt(6)));
			}  
			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}
		return list;
	}
	
	public boolean deleteAcces(int id) {
		boolean flag = false;

		        try { 
		            Connection conn = getConnection();

		            Statement stAddUser = conn.createStatement();
		            stAddUser.executeUpdate("delete from Acces where id=" + id);

		            conn.close();
		            flag = true;
		            }
		            catch(ClassNotFoundException e) {
		                System.err.println("Driver non chargé !");  e.printStackTrace();
		            } catch(SQLException e) {
		                System.err.println("Autre erreur !");  e.printStackTrace();
		            }
		        return flag;
		}
	
	// get acces by ID
	public Acces getAccesByID(int id) {
		Acces a = new Acces();
		try {
        Connection conn = getConnection();
        
        Statement stAddUser = conn.createStatement();
        ResultSet rs = stAddUser.executeQuery("select * from Acces where id=" + id);
		while(rs.next()) {
			a = new Acces(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		}  
		}
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
		return a;
	}
	public void modifierStatut(int id,String statut){
		try {
        Connection conn = getConnection();
        Statement stModifUser = conn.createStatement();
        stModifUser.executeUpdate("update Statut set nom='" + statut + "' where id=" + id);

        conn.close();
		}
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
	}
}