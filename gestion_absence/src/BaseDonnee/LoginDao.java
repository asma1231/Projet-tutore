package BaseDonnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.AjouterEtudiant;
import Beans.Login;

public class LoginDao {

	public boolean Validate(Login LoginBean) throws ClassNotFoundException {
		boolean status=false;
		String url="jdbc:mysql://localhost:3306/gestion_absence";
		String utilisateur = "root";
		String mdp= "";
		Connection con=null;
		ResultSet res =null;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			
			con = DriverManager.getConnection(url,utilisateur,mdp);
			PreparedStatement preparedStatement=con.prepareStatement("select * from users where username = ? and password = ?");
			preparedStatement.setString(1, LoginBean.getUsername());
			preparedStatement.setString(2, LoginBean.getPassword());
			System.out.println(preparedStatement);
			res = preparedStatement.executeQuery();
			status = res.next();
			
		} catch(SQLException e) {
			printSQLException(e);
		}
		
		return status;
		
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
public boolean insert(AjouterEtudiant beane) throws Exception {
		
	String url="jdbc:mysql://localhost:3306/gestion_absence";
	String utilisateur = "root";
	String mdp= "";
	Connection con=null;
	ResultSet res =null;
	
	Class.forName("com.mysql.jdbc.Driver");
	try {
		
		con = DriverManager.getConnection(url,utilisateur,mdp);
 
			String insert="insert into etudiant(nom_etudiant,prenom_etudiant,email,tel_etudiant,telParents,nom_filiere,niveau) values(?,?,?,?,?,?,?)";
			PreparedStatement ps;
			ps=con.prepareStatement(insert);
			ps.setString(1,beane.getNom());
			ps.setString(2,beane.getPrenom());
			ps.setString(3,beane.getEmail());
			ps.setInt(4,beane.getTelephone_et());
			ps.setInt(5,beane.getTelephone_par());
			ps.setString(6,beane.getFiliere());
			ps.setString(7,beane.getNiveau());
			
	        ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
		
			
		System.out.println(("erreure de la base de donnée : "+e.getMessage()));		
		
		}
		return true;
	
		
	}
		
	}
	
