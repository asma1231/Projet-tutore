package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseDonnee.LoginDao;
import Beans.AjouterEtudiant;


@WebServlet("/servajouter")
public class ServletAjouterEt extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/gestion_absence";
	String utilisateur = "root";
	String mdp= "";
	Connection con=null;
	ResultSet res =null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("mail");
		int tel_et=Integer.parseInt(request.getParameter("teletu"));
		int tel_par=Integer.parseInt(request.getParameter("telepara"));
		String filiere=request.getParameter("filiere");
		String niveau=request.getParameter("niveau");
		
		AjouterEtudiant ajouter=new AjouterEtudiant(nom,prenom,email,tel_et,tel_par,filiere,niveau);
		
		LoginDao log=new LoginDao();
		try {
			log.insert(ajouter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
