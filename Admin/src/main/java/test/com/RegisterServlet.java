package test.com;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

// Annotation-based mapping for the servlet
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
    	int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        long phone = Long.parseLong(request.getParameter("phone"));

        // Create an AdminBean object to hold the data
        AdminBean admin = new AdminBean();
        admin.setId(id);
        admin.setAdminName(name);
        admin.setPassword(password);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPhone(phone);

        // Call AdminDao to save the admin details to the database
        AdminDao dao = new AdminDao();
        
        int result = dao.registerAdmin(admin);

        // Check if the registration was successful
        if (result > 0) {
            // Registration successful, redirect to home page or show success message
            request.setAttribute("message", "Admin registration successful!");
            RequestDispatcher rd = request.getRequestDispatcher("registerSuccess.jsp");
            rd.forward(request, response);
        } else {
            // Registration failed, redirect to register page with error message
            request.setAttribute("message", "Admin registration failed. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("regiterFailed.jsp");
            rd.forward(request, response);
        }
    }
}
