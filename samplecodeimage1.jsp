<%@page import="java.io.FileOutputStream"%>
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
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish", "root", "root");
Statement st=con.createStatement();
String query="select image from productdetails";
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
        sb.append(count);
        Blob b=rs.getBlob(1);
        count+=1;
        path=sb.toString();
        byte baa[]=b.getBytes(1, (int)b.length());
        FileOutputStream fos=new FileOutputStream(path+".jpeg");
        fos.write(baa);
        fos.close();
        %>
        
        
        <b><%=rs.getString(1)%></b>
        <b><img alt=" " src="<%=path+".jpeg"%>"height="300" width="300"></b>
   
		  					  
   
   
    <% 
    }
    %>
</div>
 </div>
   </div>
   </div>
 
</body>
</html>