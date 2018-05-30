package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class buyingdao {

	public boolean buying_a_product(String firstname, String lastname,String email, String phonenumber, String address, String city, String zipcode, String state ) throws SQLException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "insert into orders1 values(?,?,?,?,?,?,?,?)");    
			ps.setString(1,firstname); 
			ps.setString(2,lastname);  
			ps.setString(3,email);
			ps.setString(4,phonenumber);
			ps.setString(5,address);
			ps.setString(6,city);
			ps.setString(7,zipcode);
			ps.setString(8,state);
			
			          
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