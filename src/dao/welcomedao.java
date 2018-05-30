package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class welcomedao {
	
	public String getUserName(String youremail) throws SQLException {
		String name = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "select firstname from user_details where youremail=?");    
			  
			ps.setString(1,youremail);  
			ResultSet rs = ps.executeQuery();  
			if(rs.next())  {
			name = rs.getString(1);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
