package com.etpms;
import com.etpms.dao.UserDAO;import jakarta.servlet.*;
public class AppListener implements ServletContextListener { public void contextInitialized(ServletContextEvent e){try{Class.forName("com.mysql.cj.jdbc.Driver");UserDAO.ensureDemoUsers();}catch(Exception ex){e.getServletContext().log("ETPMS database is unavailable. Configure ETPMS_DB_URL, ETPMS_DB_USER and ETPMS_DB_PASSWORD.",ex);}} }
