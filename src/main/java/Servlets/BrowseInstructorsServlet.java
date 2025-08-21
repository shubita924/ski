package Servlets;

import Databases.UsersDAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BrowseInstructors")
public class BrowseInstructorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json;charset=UTF-8");

        UsersDAO userDAO = new UsersDAO();
        List<User> instructors = userDAO.getAllInstructors();

        try (PrintWriter out = response.getWriter()) {
            out.print("[");
            for (int i = 0; i < instructors.size(); i++) {
                User instructor = instructors.get(i);
                out.print("{");
                out.print("\"id\":" + instructor.getId() + ",");
                out.print("\"fullname\":\"" + instructor.getFullName() + "\",");
                out.print("\"email\":\"" + instructor.getEmail() + "\"");
                out.print("}");
                if (i < instructors.size() - 1) {
                    out.print(",");
                }
            }
            out.print("]");
        }
    }
}
