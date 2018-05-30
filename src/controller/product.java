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
import dao.productdao;
import dao.logindao;
/**
 * Servlet implementation class register
 */
@WebServlet("/product")
public class product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public product() {
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
          
String  product_id= request.getParameter("product_id");
String  product_name= request.getParameter("product_name");
String  category= request.getParameter("category");

String description = request.getParameter("description"); 
String price = request.getParameter("price");
String product_image = request.getParameter("product_image");
          
productdao pdao = new productdao();

try {
	boolean result = pdao.product(product_id, product_name,category,description,price,product_image);
	if (result) {
	 out.println("sucessfully registered");
		RequestDispatcher rdsp = request.getRequestDispatcher("adminwelcome.jsp");
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
