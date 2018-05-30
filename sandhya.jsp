<%@page import="java.io.FileOutputStream"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<%@ page import="java.sql.*" %>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish","root","root");
Statement st=con.createStatement();
String query="select image from productdetails";
ResultSet rs=st.executeQuery(query);
StringBuffer sb=new StringBuffer();
sb.append("D://ufp//");
sb.append("image");
String path;
%>
   
    <%
    while(rs.next())
    { 
        int count=1;
        sb.append(count);
        Blob b=rs.getBlob(2);
        count+=1;
        path=sb.toString();
        byte baa[]=b.getBytes(1, (int)b.length());
        FileOutputStream fos=new FileOutputStream(path+".jpeg");
        fos.write(baa);
        fos.close();
        %>
        <tr>
        <td><%=rs.getString(1) %></td>
        <td><img alt="" src="<%=path+".jpeg"%>"></td>
    </tr>
    <% 
    }
    %>
    </table>
</body>
</html>
