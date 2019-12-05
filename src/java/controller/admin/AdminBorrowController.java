/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.BaseLoginController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BookBorrow;
import model.bean.BookComment;
import model.bean.Student;
import model.dal.UserDAO;

/**
 *
 * @author vy dau khac
 */
public class AdminBorrowController extends BaseLoginController {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDao = new UserDAO();
        ArrayList<BookBorrow> borrows = userDao.getBorrowsAll();
        ArrayList<BookComment> comments = userDao.getCommentsAll();
        request.setAttribute("borrows", borrows);
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/admin/borrowview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
