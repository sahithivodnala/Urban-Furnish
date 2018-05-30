<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>   
    <%@ page import="java.sql.*"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
<html>   
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
<title>Display Image overall</title>   
</head>   
<body>   
<h1>Products</h1>   
    
  
<p>   
          <%   
            //1. Retrieve all products from database   
               
            //1a.  Load the Driver   
            Class.forName("com.mysql.jdbc.Driver");   
            //1b.  Get a connection to the database   
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/urban_furnish", "root", "root");   
            //1c. Construct our SQL statement   
            PreparedStatement ps = con.prepareStatement("SELECT * FROM productdetails");   
            //1d.  Execute and retrieve our result   
            ResultSet rs = ps.executeQuery();   
               
            //2. Base on the results returned, construct a table   
        %>   
        </p>   
        <fieldset height="145" width="145">   
<legend>Product</legend>   
        <table border="0">    
         <%     
            
if(rs.next()) {        
rs.beforeFirst();  // for making sure you dont miss the first record.      
while(rs.next())      
{                        // opening while loop brackets.      
     
         %>        
       
      
    
 <td>   
        <div style=""><img border="3"  
            src="images/Beanie/<%=rs.getString("image") %>" height="145" width="145" /></div>   
               
               
            <a href="ProductDesc.jsp?ProductId=<%=rs.getString("ProductId")%>"></a>   
        </td>   
           
           
         <%        
                } //closing while loop bracket      
             }        
             else {        
                 //if no record is found, simply display a no record message        
         %>        
 Nothing.        
 <%        
             }        
          %>     
             
           </table>    
           </fieldset>    
  
  
</body>   
</html>
