package Servlets;


import Databases.UsersDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        //TODO
        //initialize necessary items

        ServletContext context = sce.getServletContext();
        context.setAttribute("usersDAO", new UsersDAO());




    }
}

