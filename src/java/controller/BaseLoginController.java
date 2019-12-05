/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dal.*;
import model.bean.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vy dau khac
 */
/*every page use account to login must extends this class to check first*/
public abstract class BaseLoginController extends HttpServlet {

    private boolean checkLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");

        if (account != null) {
            //if have account mean that user still using
            return true;
        } else {
            //if not check if have cookie account
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("account") && cooky.getValue() != null
                            && !cooky.getValue().isEmpty()) {
                        String username = cooky.getValue();
                        //check if student or admin
                        UserDAO userDAO = new UserDAO();
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
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

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
        if (checkLogin(request, response)) {
            processGet(request, response);
        } else {
            request.getRequestDispatcher("/LoginView.jsp").forward(request, response);
        }
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
        if (checkLogin(request, response)) {
            processPost(request, response);
        } else {
            request.getRequestDispatcher("/LoginView.jsp").forward(request, response);
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
