package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
		 protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
     String username = request.getParameter("username");
     String password = request.getParameter("password");

     String isValid = null;
     
         try {
			isValid = DatabaseConnection.validateLogin(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
     if (isValid=="true") {
         response.sendRedirect("Welcome.jsp");
     } 
     else if(isValid=="false") {
    	 response.getWriter().println("<p style=\"text-align: center\">Invalid Username or Password.</p>");
    
     }
     else if(isValid==null) {
    	
             // Check if any users exist
             try (Connection conn = DatabaseConnection.getConnection()) {
                 String query = "SELECT employeeName FROM employee";
                 String v=null;
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery();
                 rs.next();
                 v=rs.getString("employeeName");
                

                 if (v==null) {
                     // No user exists, proceed to registration
                     response.sendRedirect("Register.jsp");
                     return;
                 } else  {
                     // User already exists, display error message
                     response.getWriter().println("<p style=\"text-align: center\">A user already exists. Please log in or contact your administrator.</p>");
                 }
             } catch (SQLException e) {
                 // Handle database errors gracefully
                 e.printStackTrace();
                 response.getWriter().println("An error occurred. Please try again later.");
             }
         } 
 }
}


