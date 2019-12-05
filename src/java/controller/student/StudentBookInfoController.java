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
import model.bean.Book;
import model.bean.BookComment;
import model.dal.BookDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentBookInfoController extends BaseLoginController {

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
        BookDAO bookDao = new BookDAO();
        Book book = bookDao.getBookByIsbn(isbn);
        ArrayList<BookComment> comments = bookDao.getComments(isbn);
        request.setAttribute("book", book);
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("bookinfoview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
