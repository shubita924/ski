package Servlets;

import Databases.UsersDAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginInstructor")
public class LoginInstructorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/loginInstructor.html").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersDAO dao = (UsersDAO) getServletContext().getAttribute("usersDAO");
        User user = dao.validateUser(email, password);

        response.setContentType("application/json");

        if (user != null && "Instructor".equalsIgnoreCase(user.getRole())) {
            // ✅ Success
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"redirect\":\"/InstructorProfilePage.html\"}");
        } else {
            // ❌ Fail
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Invalid email or password.\"}");
        }
    }
}

