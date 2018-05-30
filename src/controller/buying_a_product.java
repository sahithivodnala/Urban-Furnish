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

import dao.buyingdao;

/**
 * Servlet implementation class register
 */
@WebServlet("/buying_a_product")
public class buying_a_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buying_a_product() {
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
          
String  firstname= request.getParameter("firstname");
String  lastname= request.getParameter("lastname");
String  email= request.getParameter("email");

String phonenumber = request.getParameter("phonenumber"); 
String address = request.getParameter("address");
String city = request.getParameter("city");
String zipcode = request.getParameter("zipcode");
String state = request.getParameter("state");
          
buyingdao bdao = new buyingdao();

try {
	boolean result = bdao.buying_a_product(firstname, lastname,email, phonenumber,address,city,zipcode,state);
	if (result) {
	 out.println("sucessfully registered");
		RequestDispatcher rdsp = request.getRequestDispatcher("ModelList.jsp");
		rdsp.include(request, response);
	} else {
		RequestDispatcher rdsp = request.getRequestDispatcher("adminwelcome.jsp");
		//out.print("Not Registered, Please Try Again");
		rdsp.include(request, response);
		
	}

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
