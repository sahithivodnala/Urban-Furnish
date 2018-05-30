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

import dao.logindao;
import dao.logindao;
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String firstname= request.getParameter("firstname");  
String lastname = request.getParameter("lastname"); 
String youremail = request.getParameter("youremail");  
String password=request.getParameter("password");

          
logindao ldao = new logindao();

try {
	boolean result = ldao.register(firstname, lastname, youremail, password);
	if (result) {
	
		RequestDispatcher rdsp = request.getRequestDispatcher("Login.jsp");
		rdsp.include(request, response);
	} else {
		RequestDispatcher rdsp = request.getRequestDispatcher("Home.html");
		//out.print("Not Registered, Please Try Again");
		rdsp.include(request, response);
		
	}

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
