package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/employe")
public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	        String employeeName = request.getParameter("username");
	        String pass = request.getParameter("password");
	        String id = request.getParameter("ID");
	        String did=request.getParameter("did");
	        String gender = request.getParameter("Gender");
	
	  
	        try {
	          
	            DatabaseConnection.insertEmployee(employeeName, pass, id,did,gender);
	            
	        } catch (SQLException e) {
	            // Handle exception
	        }
	        response.sendRedirect("successful.jsp");
	    }
	 

}  
