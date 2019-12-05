/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Administrator;
import model.bean.Student;
import model.dal.AdministratorDAO;
import model.dal.StudentDAO;

/**
 *
 * @author vy dau khac
 */
public class LoginController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("LoginView.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        //xu li login trong voi du lieu lay tu database
        UserDAO userDAO = new UserDAO();
        if (userDAO.checkPassword(username, password)) {
            if (userDAO.isStudent(username)) {
                StudentDAO studentDAO = new StudentDAO();
                Student student = studentDAO.getInfo(username);
                session.setAttribute("account", student);
                session.setAttribute("account role", "student");
            } else {
                AdministratorDAO adminDAO = new AdministratorDAO();
                Administrator admin = adminDAO.getInfo(username);
                session.setAttribute("account", admin);
                session.setAttribute("account role", "administrator");
            }

            //auto add cookie for user
            Cookie cooky = new Cookie("account", username);
            cooky.setMaxAge(600); //set cookie 10 min
            response.addCookie(cooky);
            response.sendRedirect("home");
        } else {
            session.setAttribute("account", null);
            response.sendRedirect("login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
