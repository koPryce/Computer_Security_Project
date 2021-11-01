package project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String [] args) {
//		insert("Ken", "James", "kj@gmail.com", "8763902930", "kjames1", "kjamesthebomb");
//		readEntireTable();
//		readUserInformation();
//		updateUser();
//		deleteUser();
		numberOfUsers();
	}
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:electronicAuthenticationSystemDatabase.db");
			System.out.println("Connected!");
		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
			System.out.println(e+"");
		}
		
		return connection;
	}
	
	public static void insert(String firstName, String lastName, String emailAddress, String phoneNumber, String userName, String password) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users(firstName, lastName, emailAddress, phoneNumber, userName, password) VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, emailAddress);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, userName);
			preparedStatement.setString(6, password);
			preparedStatement.execute();
			System.out.println("User created successfully!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public static void readEntireTable() {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT * FROM users";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("ALL USERS\n");
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String emailAddress = resultSet.getString("emailAddress");
				String phoneNumber = resultSet.getString("phoneNumber");
				String userName = resultSet.getString("userName");
				String password = resultSet.getString("password");
				
				System.out.println("First Name: "+firstName);
				System.out.println("Last Name: "+lastName);
				System.out.println("Email Address: "+emailAddress);
				System.out.println("Phone Number: "+phoneNumber);
				System.out.println("Username: "+userName);
				System.out.println("Password: "+password+"\n\n");
			}
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		
	}
	
	public static void readUserInformation() {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT firstName, lastName, emailAddress, phoneNumber, password FROM users WHERE userName = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "kjames");
			resultSet = preparedStatement.executeQuery();
			
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String emailAddress = resultSet.getString("emailAddress");
			String phoneNumber = resultSet.getString("phoneNumber");
			String password = resultSet.getString("password");
			
			System.out.println("First Name: "+firstName);
			System.out.println("Last Name: "+lastName);
			System.out.println("Email Address: "+emailAddress);
			System.out.println("Phone Number: "+phoneNumber);
			System.out.println("Password: "+password+"\n\n");
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		
	}
	
	public static void updateUser() {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE users set firstName = ? WHERE userName = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Klaus");
			preparedStatement.setString(2, "kjames1");
			preparedStatement.execute();
			System.out.println("User updated successfully!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public static void deleteUser() {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "DELETE FROM users WHERE userName = ?"; //and password
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "kjames1");
			preparedStatement.execute();
			System.out.println("User has been removed successfully!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
	}

	public static void numberOfUsers() {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT count(userName) FROM users";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			int size = resultSet.getInt(1);
			System.out.println("There is/are "+size+" user(s) in the system.");
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
	}
}
