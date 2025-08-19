package Servlets;

import Databases.UsersDAO;
import Objects.User;
import utils.PasswordHasher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerInstructor")
public class RegisterInstructorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            request.getRequestDispatcher("/registerInstructor.html").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String role = request.getParameter("role"); // "Instructor" or "Student"
        String phone = request.getParameter("phone");

        ServletContext context = getServletContext();
        UsersDAO dao = (UsersDAO) context.getAttribute("usersDAO");

        // Check if user already exists
        User existingUser = dao.getUserByEmail(email);
        if (existingUser != null) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_CONFLICT); // 409
            response.getWriter().write("{\"error\":\"User with this email already exists.\"}");
            return;
        }


        // Hash password
        PasswordHasher hasher = new PasswordHasher();
        String salt = hasher.generateSalt();
        String hashedPassword = hasher.hashPassword(password, salt);


        // Create new user
        User newUser = new User(email, fullname, salt, hashedPassword, role, phone);

        dao.addUser(newUser);

        // Respond success
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setContentType("application/json");
        response.getWriter().write("{\"redirect\":\"/InstructorProfilePage.html\"}");

    }


}
