/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseLoginController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.BookBorrow;
import model.bean.Student;
import model.dal.StudentDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentNewsController extends BaseLoginController {

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
        StudentDAO studentDao = new StudentDAO();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("account");
        ArrayList<BookBorrow> overdue = studentDao.getOverdueBooks(student.getUsername());
        request.setAttribute("overdue", overdue);
        request.getRequestDispatcher("newsview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
