/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.BaseLoginController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Book;
import model.dal.BookDAO;

/**
 *
 * @author vy dau khac
 */
public class AdminSearchController extends BaseLoginController {

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
        ArrayList<String> categories = bookDAO.getAllCategories();
        request.setAttribute("categories", categories);
        ArrayList<String> languages = bookDAO.getAllLanguages();
        request.setAttribute("languages", languages);
        ArrayList<String> formats = bookDAO.getAllFormats();
        request.setAttribute("formats", formats);
        int pageindex = 1;
        int pagesize = 3;
        ArrayList<Book> books = bookDAO.getAllBooksDescription(pageindex, pagesize);
        int totalrecord = bookDAO.totalRecord();
        int totalpage = totalrecord % pagesize == 0 ? totalrecord / pagesize : totalrecord / pagesize + 1;
        request.setAttribute("books", books);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("totalpage", totalpage);
        request.getRequestDispatcher("searchview").forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
