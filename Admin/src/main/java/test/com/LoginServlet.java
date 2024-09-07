package test.com;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");

        AdminDao dao = new AdminDao();
        AdminBean admin = dao.loginAdmin(adminName, password);

        if (admin != null) {
            // Login successful, redirect to success page
            request.setAttribute("adminName", admin.getAdminName());
            RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
            rd.forward(request, response);
        } else {
            // Login failed, show error message on login page
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
