package project.mental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.j2objc.annotations.RetainedLocalRef;

public class DbConnect {
    private static final String DB_URL="jdbc:sqlite:db/db_userapp.db";
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static String query;

    public static void connection(){
        try {
            connection=DriverManager.getConnection(DB_URL);
            System.out.println("Database connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean validasiLogin(String username) {
        connection();
        String query="SELECT Name FROM usermentalcheck WHERE Name=?";
        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, username);
           
            try(ResultSet login  = preparedStatement.executeQuery()){
                
                return login.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
}
    public static boolean validasiPassword(int password) {
        connection();
        String query="SELECT Pass FROM usermentalcheck WHERE Pass=?";
        try {
            preparedStatement=connection.prepareStatement(query);
            
            preparedStatement.setInt(1, password);
            try(ResultSet login  = preparedStatement.executeQuery()){
                
                return login.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
}
public static void tambahData(String username, int password) {
    String query = "INSERT INTO usermentalcheck (Name, Pass) VALUES (?, ?)";
    
    try (Connection connection = DriverManager.getConnection(DB_URL);
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, password);
        
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Data berhasil ditambahkan ke database.");
        } else {
            System.out.println("Gagal menambahkan data ke database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
}
