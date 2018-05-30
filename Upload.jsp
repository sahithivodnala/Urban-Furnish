<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       
    </head>
    <body>
        <h1>File Upload to Database</h1>
        <form name="fileform" method="post" action="FileUploadDBServlet" enctype="multipart/form-data">
            <label for="product_name">Product Name:</label>
            <input type="text" name="product_name" size="50" placeholder="Enter Your FirstName" required/><br><br>
            <label for="category">Category: </label>
            <input type="text" name="category" size="50" placeholder="Enter Your LastName" required/><br><br>
            <label for="description">Description: </label>
            <input type="text" name="description" size="50" placeholder="Enter Your LastName" required/><br><br>
            <label for="price">Price: </label>
            <input type="text" name="price" size="50" placeholder="Enter Your LastName" required/><br><br>
            <label for="image"> Portrait Photo:  </label>
            <input type="file" name="image" size="50" placeholder="Upload Your Image" required/><br><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
