/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseLoginController;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vy dau khac
 */
public class StudentCartController extends BaseLoginController {

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
        String title = request.getParameter("title");
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            HashMap<String, String> cart = new HashMap<>();
            session.setAttribute("cart", cart);//create new
        }
        HashMap<String, String> cart = (HashMap<String, String>) session.getAttribute("cart");
        cart.put(isbn, title);
        session.setAttribute("cart", cart); //update
        response.getWriter().write("Your chosen book has been added to list");
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //remove
        String isbn = request.getParameter("isbn");
        HttpSession session = request.getSession();
        HashMap<String, String> cart = (HashMap<String, String>) session.getAttribute("cart");
        cart.remove(isbn);
        session.setAttribute("cart", cart);//create new
        response.getWriter().write("Your chosen book has been removed to list");
    }

}
