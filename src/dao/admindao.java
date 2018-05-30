package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admindao {
	public boolean validate(String email, String password) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
			PreparedStatement ps = con.prepareStatement("Select email,password from admin where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
