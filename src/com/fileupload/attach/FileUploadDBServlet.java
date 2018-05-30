package com.fileupload.attach;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadDBServlet")
@MultipartConfig(maxFileSize = 16177215)
// upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
    private static final int BUFFER_SIZE = 4096;
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/urban_furnish";
    private String dbUser = "root";
    private String dbPass = "root";

    //naive way to obtain a connection to database
    //this MUST be improved, shown for 
    private Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/urban_furnish", "root", "root");
        } catch (Exception e) {
            //wrapping any exception and rethrowing it
            //inside a RuntimeException
            //so the method is silent to exceptions
            throw new RuntimeException("Failed to obtain database connection.", e);
        }
        return conn;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //get values of text fields
        String product_name = request.getParameter("product_name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String price =request.getParameter("price");
        InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtains input stream of the upload file
            //the InputStream will point to a stream that contains
            //the contents of the file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null; // message will be sent back to client
        try {
            // connects to the database
            conn = getConnection();
            // constructs SQL statement
            String sql = "INSERT INTO productdetails (product_name, category,description,price,image) values (?, ?, ?,?,?)";
            //Using a PreparedStatement to save the file
            PreparedStatement pstmtSave = conn.prepareStatement(sql);
            pstmtSave.setString(1, product_name);
            pstmtSave.setString(2, category);
            pstmtSave.setString(3, description);
            pstmtSave.setString(4, price);

            if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                pstmtSave.setBlob(5, inputStream);
            }
            //sends the statement to the database server
            int row = pstmtSave.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }

            String filepath = "D:/Dev/JavaWorkSpaceNew/FileUploadDatabase/WebContent/FromDb.jpg";
            //Obtaining the file from database
            //Using a second statement
            String sql1 = "SELECT image FROM productdetails WHERE product_name=? AND category=?";
            PreparedStatement pstmtSelect = conn.prepareStatement(sql1);
            pstmtSelect.setString(1, product_name);
            pstmtSelect.setString(2, category);
           // PreparedStatement statement1 = null;
			ResultSet result = pstmtSelect.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("image");
                InputStream inputStream1 = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream1.close();
                outputStream.close();
                System.out.println("File saved");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //silent
                }
            }
            // sets the message in request scope
            request.setAttribute("message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp")
                .include(request, response);
        }
    }
}