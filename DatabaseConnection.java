package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

	 public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/employees";
		 String user = "root";
		 String password = "Pakistan123!@#";
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return DriverManager.getConnection(url, user, password);
		 }

		 public static  String validateLogin (String username, String password) throws SQLException {
		 Connection conn = null;
		 PreparedStatement stmt = null;
	     ResultSet rs = null;
	     String validate = null;
	     

		try {
		conn = getConnection();
		String query = "SELECT employeeName,password FROM employee";
		 stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();
	        

	        while (rs.next()) {
	            String dbUsername = rs.getString("employeeName");
	            String dbPassword = rs.getString("password");

	            if (username.equalsIgnoreCase(dbUsername) && password.equals(dbPassword)) {
	                validate="true";
	                break;
	            }
	            else {
	            	validate="false"; 
	            }
	        }
	        
	       
		 
		 } catch (SQLException e) {
		 throw e;
		 } finally {
		 closeResources(conn, stmt, rs);
		 }
		return validate;
		 }
		 public static  String validateLog () throws SQLException {
			 Connection conn = null;
			 PreparedStatement stmt = null;
		     ResultSet rs = null;
		     String dbUsername = null;
		 
			try {
			conn = getConnection();
			String query = "SELECT employeeName FROM employee";
			 stmt = conn.prepareStatement(query);
		        rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		            dbUsername = rs.getString("employeeName");
		          
		        }
		    
			 } catch (SQLException e) {
			 throw e;
			 } finally {
			 closeResources(conn, stmt, rs);
			 }
			return dbUsername;
			 }
		
	public static void insertEmployee(String employeeName, String pass, String id, String did, String gender) throws SQLException {
		 Connection conn = null;
		 PreparedStatement stmt = null;

		try {
		conn = getConnection();
		 String query = "INSERT INTO employee (employee_ID,employeeName,gender,password,department_ID) VALUES (? ,?, ?, ?, ?)";
		 stmt = conn.prepareStatement(query);
		 stmt.setString(1, id);
		stmt.setString(2, employeeName);
		stmt.setString(3,gender);
		 stmt.setString(4,pass);
		 stmt.setString(5, did);
		
		 stmt.executeUpdate();
		} catch (SQLException e) {
		 throw e;
		 } 
		finally {
		 closeResources(conn, stmt, null);
		} 
		}
	// ... (existing code)

	public static void insertDepartment(String departmentId, String departmentName) throws SQLException {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = getConnection();
	        String query = "INSERT INTO department (department_ID, departmentName) VALUES (?, ?)";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, departmentId);
	        stmt.setString(2, departmentName);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        closeResources(conn, stmt, null);
	    }
	    
	}
	
	public static void Register(String employeeName, String pass, String gender) throws SQLException {
		 Connection conn = null;
		 PreparedStatement stmt = null;

		try {
		conn = getConnection();
		 String query = "INSERT INTO employee (employeeName,gender,password) VALUES ( ?, ?, ?)";
		 stmt = conn.prepareStatement(query);
		
		stmt.setString(1, employeeName);
		stmt.setString(2,gender);
		 stmt.setString(3,pass);
		
		
		 stmt.executeUpdate();
		} catch (SQLException e) {
		 throw e;
		 } 
		finally {
		 closeResources(conn, stmt, null);
		} 
	}
	public static List<String> getDepartmentNames() throws SQLException {
	    List<String> departmentNames = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        conn = getConnection();
	        String query = "SELECT departmentName FROM department";
	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            departmentNames.add(rs.getString("departmentName"));
	        }
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        closeResources(conn, stmt, rs);
	    }

	    return departmentNames;
	}
	
	
		 private static void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) throws SQLException {
		 if (rs != null) {
		 rs.close();
		 }
		 if (stmt != null) {
		 stmt.close();
		}
		if (conn != null) {
		 conn.close();
	}
		 }
}

