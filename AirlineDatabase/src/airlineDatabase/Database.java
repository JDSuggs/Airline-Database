package airlineDatabase;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Database {

	// Variable that holds connection
	public static Connection conn = null;

	// Variable that holds view
	public static String view = "";

	// Loads the driver
	public static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Driver instance ok...");
		} catch (Exception e) {
			System.err.println("Unable to load driver.");
			e.printStackTrace();
		}
	}

	// Prepared Statement login to prevent SQL injection
	public static String login(Connection conn) throws SQLException {

		String user = "";
		String password = "";
		String view = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Username:  ");
			user = br.readLine();
		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		password = getPassword();
		password = hashPassword(password);

		PreparedStatement login = null;

		String selectSQL = "select view from views where username = ? and password = ?";

		try {

			login = conn.prepareStatement(selectSQL);
			login.setString(1, user);
			login.setString(2, password);

			ResultSet rs = login.executeQuery();
			while (rs.next()) {

				System.out.println();
				view = rs.getString("View");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (login != null) {
				login.close();
			}
		}
		return view;
	}

	// Get password
	public static String getPassword() {
		String enterPassword = "Enter password";
		String password;
		JPasswordField passwordPrompt = new JPasswordField();
		password = JOptionPane.showConfirmDialog(null, passwordPrompt, enterPassword, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(passwordPrompt.getPassword()) : "";
		return password;
	}

	// Hash password for protection
	public static String hashPassword(String password) {
		String hPassword = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hPassword;
	}

	// Establishes connection with parameters
	public static Connection establish_connection(String database_name, String sql_username, String sql_passwd) {
		Connection conn = null;
		try {

//			System.out.println("Establishing connection with MySql server on satoshi..");
			conn = DriverManager
					.getConnection("jdbc:mysql://152.20.12.152/" + database_name + "?noAccessToProcedureBodies=true"
							+ "&useSSL=false" + "&user=" + sql_username + "&password=" + sql_passwd);

//			System.out.println("Connection with MySql server on satoshi.cis.uncw.edu established.");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState:     " + e.getSQLState());
			System.out.println("VendorError:  " + e.getErrorCode());
		}

		return conn;
	}

	// Gets parameters for connections and calls establish connection to connect
	public static Connection connection() throws IOException {

		String database_name = "", username = "", password = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Database name? ");
		try {
			database_name = br.readLine();
		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid Format!");
		}
		System.out.print("Satoshi Username? ");
		try {
			username = br.readLine();
		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid Format!");
		}
		password = getPassword();

		Connection conn = establish_connection(database_name, username, password);

		return conn;
	}

	// Closes connection
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {
			try {
				conn.close();
//				System.out.println("\n" + "Closed connection");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Establishes connection and starts program
	public static void main(String[] args) throws IOException, SQLException {
		Connection conn = null;
		Database.view = "";
		while (conn == null) {
			loadDriver();
//			use connection() to log in with your credentials
			conn = connection();
			System.out.println("\n" + "\n");
			Database.view = login(conn);
			System.out.println("\n" + "\n");
		}
		Database.conn = conn;
		if (view.equals("all")) {
			Menu.mainMenu();
		} else if (view.equals("customer")) {
			Menu.mainMenu1();
		} else if (view.equals("admin")) {
			Menu.administrativeFunctionsMenu();
		}
		closeConnection(conn);
		System.out.println("\n" + "Quit");
	}
}
