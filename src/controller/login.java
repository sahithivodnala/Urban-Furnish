package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.logindao;
import dao.welcomedao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
          
		String youremail=request.getParameter("youremail");  
		String password=request.getParameter("password");    
		logindao ldao = new logindao();
		boolean result = ldao.validate(youremail, password);		
		if (result) {	
			welcomedao weldao = new welcomedao();
			try {
				
			String name = weldao.getUserName(youremail);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);

			
			RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");  
			rd.forward(request,response);  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {  
			out.print("Sorry your email or password error!!");  
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			rd.include(request,response);  
		}  
	}
}