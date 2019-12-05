/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseLoginController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Book;
import model.bean.Student;
import model.dal.StudentDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentBorrowController extends BaseLoginController {

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
        //get book from cart
        HttpSession session = request.getSession();
        HashMap<String, String> cart = (HashMap<String, String>) session.getAttribute("cart");
        ArrayList<Book> books = new ArrayList<>();
        if (cart != null) {
            for (String isbn : cart.keySet()) {
                Book b = new Book();
                b.setIsbn(isbn);
                b.setTitle(cart.get(isbn));
                books.add(b);
            }
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("borrowview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all borrow from session cart and save to database
        HttpSession session = request.getSession();
        HashMap<String, String> cart = (HashMap<String, String>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
            Student s = (Student) session.getAttribute("account");
            String username = s.getUsername();
            //with each isbn from cart + username to add to database
            StudentDAO sDao = new StudentDAO();
            sDao.borrowBooks(username, cart.keySet());
            //add done then set cart to null
            session.setAttribute("cart", null);
        }
        //move back to borrow view
        response.sendRedirect("search");
    }

}
