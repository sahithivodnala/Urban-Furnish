<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String productId = request.getParameter("productId");
Connection con = null;
Statement st = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish", "root", "root");
st=con.createStatement();
String query="select image from productdetails where product_id = "+productId+" and category='Dressing table'";
ResultSet rs=st.executeQuery(query);
OutputStream o = response.getOutputStream();
while(rs.next())
{ 
	Blob bl = rs.getBlob(1);
    byte[] pict = bl.getBytes(1,(int)bl.length());
    response.setContentType("image/jpg");
    o.write(pict);
    o.flush();
    o.close();
	
	/*String imgLen1 = "";
    imgLen1 = rs.getString("image");
    System.out.println(imgLen1.length());
    int len1 = imgLen1.length();
    byte[] rb = new byte[len1];
    InputStream readImg = rs.getBinaryStream(1);
    int index = readImg.read(rb, 0, len1);
    System.out.println("index" + index);
    response.setContentType("image/jpg");*/
    //response.getOutputStream().write(rb, 0, len1);
}
} finally {
	if(st != null) {
		st.close();
	}
	if(con != null) {
		con.close();
	}
}
%>
</body>
</html>