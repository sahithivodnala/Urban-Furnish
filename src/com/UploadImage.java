package com;
 
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.productdao;
 
@WebServlet("/UploadImage")
@MultipartConfig(maxFileSize = 16177216)
public class UploadImage extends HttpServlet{
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String connectionURL = "jdbc:mysql://localhost:3306/urban_furnish";
		String user = "root";
		String pass = "root";
 
		int result = 0;
		Connection con = null;
		String  product_name= req.getParameter("product_name");
		String  category= req.getParameter("category");

		String description = req.getParameter("description"); 
		String price = req.getParameter("price");

		
		Part part = req.getPart("image");
 
		if(part != null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish","root","root");
			    
			    PreparedStatement ps = con.prepareStatement("insert into productdetails values(?,?,?,?,?)");
			  
			    ps.setString(1,product_name);
				ps.setString(2,category);
				ps.setString(3,description);  
				ps.setString(4,price); 
			    InputStream is = part.getInputStream();
			    ps.setBlob(5, is);
			    result = ps.executeUpdate();
			
			    if(result>0)  {
					String sql = "select youremail from user_details;";
					Statement stat = con.createStatement();
					stat.executeQuery(sql);
					result = 1;
				}

			
			    
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			finally{
				if(con != null){
					try{
						con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		
		
		if(result > 0){
	    	resp.sendRedirect("result.jsp?message=Image+Uploaded");
	    }
		else{
			resp.sendRedirect("result.jsp?message=Some+Error+Occurred");
		}
	}
	}
}
