package Servlets;

import Databases.UsersDAO;
import Objects.User;

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


    public void doPost(HttpServletRequest request, HttpServletResponse response){

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        ServletContext context = getServletContext();

        UsersDAO dao = (UsersDAO) context.getAttribute("usersDAO");

        User newUser = new User("newuser@gmail.com", "New User", "salt123", "hashedpass", "Student", "555-1234");
        dao.addUser(newUser);

        // Get by email
//        User user = dao.getUserByEmail("newuser@gmail.com");
//        if (user != null) {
//            System.out.println("Found user: " + user.getFullname());
//        }

        // Get all users
        for (User u : dao.getAllUsers()) {
            System.out.println(u.getId() + " " + u.getEmail() + " " + u.getRole());
        }
    }

}
