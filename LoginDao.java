package net.javaguides.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	/*public boolean validate(String username, String password) {
	    try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	         PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {

	        System.out.println("Connected to database"); // Debug uchun
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);
	        System.out.println("Query executed: " + preparedStatement); // Debug uchun
	        ResultSet resultSet = preparedStatement.executeQuery();

	        return resultSet.next();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}*/

	
	
	
    private String jdbcURL = "jdbc:mysql://localhost:3306/registerForm"; // Database URL
    private String jdbcUsername = "root"; // Database foydalanuvchi ismi
    private String jdbcPassword = "password"; // Database paroli

    private static final String LOGIN_QUERY = "SELECT * FROM login WHERE username = ? AND password = ?";

    public boolean validate(String username, String password) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {
        	
        	System.out.println("Connected to database"); // Debug uchun


            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            System.out.println("Query executed: " + preparedStatement); // Debug uchun
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Foydalanuvchi mavjud bo'lsa, true qaytaradi
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

