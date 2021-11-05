package project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:electronicAuthenticationSystemDatabase.db");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
		}
		
		return connection;
	}
	
	public static void insertUser(String firstName, String lastName, String emailAddress, String phoneNumber, String password) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users(firstName, lastName, emailAddress, phoneNumber, password) VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, emailAddress);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, password);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static String authUser(String email) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT password FROM users WHERE emailAddress = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			
			String password = resultSet.getString("password");
			return password;
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
		return "User does not exist";
	}
	
	public static Boolean authEmail(String email) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT emailAddress FROM users WHERE emailAddress = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			
			String semail = resultSet.getString("emailAddress");
			if(email.equals(semail)) {
				return true;
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
		return false;
	}
	
	public static int getUserID(String email) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT userID FROM users WHERE emailAddress = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			
			int uid = resultSet.getInt("userID");
			return uid;
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
		return 0;
	}
	
	public static String getPhoneNumber(String email) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT phoneNumber FROM users WHERE emailAddress = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			
			String phoneNumber = resultSet.getString("phoneNumber");
			return phoneNumber;
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
		return "";
	}
	
	public static void addQRCode(String qrcode, String date, String status) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO qrcode(qrcode, date, status) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, qrcode);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, status);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static Boolean validateOTP(String otp) {
		Connection connection = connect();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			String sql = "SELECT otp FROM otp WHERE otpID = (SELECT MAX(otpID) FROM otp)";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			String sotp = resultSet.getString("otp");
			if(sotp.equals(otp)) {
				return true;
			}			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		return false;
	}
	
	public static void updateQRCodeStatus(String status, int qrcodeID) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE qrcode set status = ? WHERE qrcodeID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, qrcodeID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static int getQRCodeID() {
		Connection connection = connect();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			String sql = "SELECT qrcodeID FROM qrcode WHERE qrcodeID = (SELECT MAX(qrcodeID) FROM qrcode)";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			int qid = resultSet.getInt("qrcodeID");
			return qid;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		return 0;
	}
	
	public static void addOTP(String otp, String date, String status) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO otp(otp, date, status) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, otp);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, status);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void updateOTPStatus(String status, int otpID) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE otp set status = ? WHERE otpID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, otpID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static int getOTPID() {
		Connection connection = connect();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			String sql = "SELECT otpID FROM otp WHERE otpID = (SELECT MAX(otpID) FROM otp)";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			int oid = resultSet.getInt("otpID");
			return oid;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		return 0;
	}
	
	public static void insertUserOTP(int userID, int otpID) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users_otp(userID, otpID) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, otpID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void insertUserQRCode(int userID, int qrcodeID) {
		Connection connection = connect();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO users_qrcode(userID, qrcodeID) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, qrcodeID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static Boolean validateQRCode(String qrcode) {
		Connection connection = connect();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			String sql = "SELECT qrcode FROM qrcode WHERE qrcodeID = (SELECT MAX(qrcodeID) FROM qrcode)";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			String sqrcode = resultSet.getString("qrcode");
			if(sqrcode.equals(qrcode)) {
				return true;
			}			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
		return false;
	}
	
}
