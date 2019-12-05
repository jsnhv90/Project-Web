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
import model.dal.BookDAO;
import model.dal.UserDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentCommentController extends BaseLoginController {

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
        String isbn = request.getParameter("isbn");
        String username = request.getParameter("username");
        float rate = Float.parseFloat(request.getParameter("rate"));
        String comment = request.getParameter("comment");
        UserDAO userDao = new UserDAO();
        BookDAO bookDao = new BookDAO();
        userDao.comment(isbn, username, rate, comment);
        bookDao.updateRating(isbn);
        response.getWriter().write("Your comment has been added");
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
