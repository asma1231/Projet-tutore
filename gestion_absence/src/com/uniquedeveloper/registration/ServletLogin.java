package com.uniquedeveloper.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BaseDonnee.LoginDao;
import Beans.Login;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		loginDao = new LoginDao();
		 Login loginBean = new Login();
		 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if((loginDao).Validate(loginBean)) {
				//session.setAttribute("login", username);
		    	//session.setAttribute("pwd", password);
				response.sendRedirect("MenuG.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}	
		
		
	}
}
