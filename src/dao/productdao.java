package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class productdao {

	public boolean product(String product_id,String product_name,String category, String description, String price,String product_image) throws SQLException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "insert into products values(?,?,?,?,?,?)");    
			ps.setString(1,product_id);
			ps.setString(2,product_name);
			ps.setString(3,category);
			ps.setString(4,description);  
			ps.setString(5,price);
			ps.setString(6,product_image);
			
			          
			int i=ps.executeUpdate();  
			if(i>0)  {
				String sql = "select youremail from user_details;";
				Statement stat = con.createStatement();
				stat.executeQuery(sql);
				status = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	
//	public boolean validate(String email, String password) {
	//	boolean status = false;
		//try {
			//Class.forName("com.mysql.jdbc.Driver");
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
			//PreparedStatement ps = con.prepareStatement("Select youremail,password from user_details where youremail=? and password=?");
		//	ps.setString(1, email);
		//	ps.setString(2, password);
		//	ResultSet rs = ps.executeQuery();
			//if (rs.next()) {
				//status = true;
		//	} 
		//} catch (ClassNotFoundException | SQLException e) {
			//e.printStackTrace();
	//	}
		//return status;
//	}
}