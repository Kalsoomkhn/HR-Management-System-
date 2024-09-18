package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/depart")
public class departmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			        String departmentId = request.getParameter("departmentId");
			        String departmentName = request.getParameter("departmentName");  
			        try {
						DatabaseConnection.insertDepartment(departmentId, departmentName);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        response.sendRedirect("successful.jsp");
			    }
}
