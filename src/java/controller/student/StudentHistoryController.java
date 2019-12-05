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
import model.bean.BookBorrow;
import model.bean.BookComment;
import model.bean.Student;
import model.dal.BookDAO;
import model.dal.UserDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentHistoryController extends BaseLoginController {

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
        UserDAO userDao = new UserDAO();
        Student s = (Student) request.getSession().getAttribute("account");
        String username = s.getUsername();
        ArrayList<BookBorrow> borrows = userDao.getBorrows(username);
        ArrayList<BookComment> comments = userDao.getComments(username);
        request.setAttribute("borrows", borrows);
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("historyview").forward(request, response);
        
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
