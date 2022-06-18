package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegistartionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name"); 
		String umail=request.getParameter("email"); 
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		String url ="jdbc:mysql://localhost:3306/gestion_absence";
		String utilisateur = "root";
		String mdp = "";
		Connection con = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			
			
			 con= DriverManager.getConnection(url,utilisateur,mdp);
			PreparedStatement pst=con.prepareStatement("insert into users(username,password,email,mobile) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upwd);
			pst.setString(3, umail);
			pst.setString(4, umobile);
			int rowcount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowcount > 0) {
				request.setAttribute("status", "succes");
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
