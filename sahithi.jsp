<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<% 
byte[] imgData = null;
%>
<%
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con =  
DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish","root","root");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select image from productdetails ");

while (rs.next()) {
Blob image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
 }
// display the image
response.setContentType("image/jpeg");
OutputStream o = response.getOutputStream();
%>

<img="<%o.write(imgData);%>" width="10" height="20">
<%o.flush();
o.close();

out.println("hi");
rs.close();
stmt.close();
con.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} 

%>