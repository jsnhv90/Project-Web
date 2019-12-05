/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseLoginController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Student;
import model.dal.StudentDAO;
import model.dal.UserDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentProfileController extends BaseLoginController {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("profileview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        //response.getWriter().write(username + " " + password + " " + phone + " " + email + " " + address);
        UserDAO userDao = new UserDAO();
        userDao.update(username, password, phone, address, email);
        //after update to db we need update to session acc
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("account");
        student.setPassword(password);
        student.setPhone(phone);
        student.setAddress(address);
        student.setEmail(email);
        session.setAttribute("account", student);
        response.sendRedirect("profile");
    }

}
