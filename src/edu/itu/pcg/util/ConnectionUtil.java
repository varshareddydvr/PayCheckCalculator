package edu.itu.pcg.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.itu.pcg.dto.BaseDto;

/**
 * @author Kavya and Varsha
 *
 */
public class ConnectionUtil {

	private static Connection conn = null;
	
	private ConnectionUtil(){
		// nothing to do
	}
	
	public static Connection getConnection() throws SQLException {
		if (conn != null) {
			return conn;
		}
		
		try {
			String dbPath = System.getProperty("db.path", "payroll.db");
			System.out.println("DB path: "+dbPath);
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
		} catch(Exception e){
			e.printStackTrace();
			throw new SQLException("failed to establish connection");
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void executeQuery(String query, BaseDto dto) {
		try {
			System.out.println("query - "+query);
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			dto.setResultSetData(rs);
			System.out.println("query result - "+dto);
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executeUpdateQuery(String querySrcFile) {
		BufferedReader buffReader = null;
		FileReader fileReader = null;
		
		try {
			Connection conn = getConnection();
			fileReader = new FileReader(querySrcFile);
			buffReader = new BufferedReader(fileReader);
			String line = null;
			Statement stmt = null; 
			while ((line = buffReader.readLine()) != null) {
				System.out.println("execute sql query - "+line);
				stmt = conn.createStatement();
				int result = stmt.executeUpdate(line);
				System.out.println("execute sql result - "+result);
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//TODO - check for null
				buffReader.close();
				fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	public static void main(String[] args) throws SQLException {
		Connection con = getConnection();
		System.out.println("got connection");
		closeConnection();
		System.out.println("connection closed");
	}
	*/
	
}
