<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body bgcolor="white">
<%@ page import="java.sql.*" %>
<%
Connection con = null;
Statement st = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish", "root", "root");
st=con.createStatement();
String query="select product_id,image,product_name,description,price from productdetails where category='Dressing table'";
ResultSet rs=st.executeQuery(query);
StringBuffer sb=new StringBuffer();
sb.append("D://ufp//");
sb.append("image");
String path;
%>
      
    
    <div class="w3-content w3-margin-top" style="max-width: 2600px;">
		<div class="row">
		<div class="col-sm-4">
          <div class="well">
          
                    
          
          
         
    <%
    while(rs.next())
    { 
        int count=1;
        String productId = rs.getString("product_id");
        sb.append(count);
        path="sample";
        /*Blob b=rs.getBlob("image");
        count+=1;
        path=sb.toString();
        byte baa[]=b.getBytes(1, (int)b.length());
        FileOutputStream fos=new FileOutputStream(path+".jpeg");
        fos.write(baa);
        fos.close();*/
        
        
        
        %>
        
        
        <b><%=rs.getString(1)%></b>
        <b><img alt="" src="readImage.jsp?productId=<%=productId%>" height="300" width="300"></b>
   
		  <div class="well">
         
            <b>Name   :</b>
           	<%=rs.getString("product_name")%></br>
           	<b>Description   :</b>
		<%=rs.getString("description")%></br>
		<b>Price   :</b>
		<%=rs.getString("price")%></br>
		          <div class="container">
								<div class="btn-group">
									<a href="appointment.html" class="btn btn-info" role="button">Apppointment</a>
		
								</div>
							</div>
          </div>
        					  
   
   
    <% 
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
</div>
 </div>
   </div>
   </div>
 
</body>
</html>