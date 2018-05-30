package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admindao;


/**
 * Servlet implementation class register
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
          
		String email=request.getParameter("email");  
		String password=request.getParameter("password");    
		admindao ldao = new admindao();
		boolean result = ldao.validate(email, password);		
		if (result) {
			RequestDispatcher rd=request.getRequestDispatcher("adminwelcome.jsp");  
			rd.forward(request,response);  
		} else {  
			out.print("Sorry youremail or password error");  
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");  
			rd.include(request,response);  
		}  
	}
}