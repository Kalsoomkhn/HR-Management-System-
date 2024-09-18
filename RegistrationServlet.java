package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String employeeName = request.getParameter("username");
        String pass = request.getParameter("password");
       
  
        String gender = request.getParameter("Gender");

  
        try {
          
            DatabaseConnection.Register(employeeName, pass, gender);
            
        } catch (SQLException e) {
            // Handle exception
        }
        response.sendRedirect("successful.jsp");
	}

}
