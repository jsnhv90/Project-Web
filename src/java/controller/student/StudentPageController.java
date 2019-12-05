/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseLoginController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Book;
import model.dal.BookDAO;

/**
 *
 * @author vy dau khac
 */
public class StudentPageController extends BaseLoginController {

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
        int pageindex = Integer.parseInt(request.getParameter("pageindex"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        String publisher = request.getParameter("publisher");
        String language = request.getParameter("language");
        String format = request.getParameter("format");
        int pagesize = 3;
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = bookDAO.filterBookDescription(title, author, 
                category, publisher, language, format, pageindex, pagesize);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("books", books);
        int totalrecord = bookDAO.totalRecordFilter(title, author, category, publisher, language, format);
        int totalpage = totalrecord % pagesize == 0 ? totalrecord / pagesize : totalrecord / pagesize + 1;
        PrintWriter writer = response.getWriter();
        for (Book b : books) {
            writer.write("<div class=\"w3-container w3-white\">");
            writer.write("<div class=\"w3-quarter w3-margin\">");
            writer.write("<img src=\"/BookManagement/images/"+b.getImage()+"\" class=\"w3-image\" style=\"height: 300px; margin-left: 10%; margin-bottom: 10px\">");
            writer.write("<input class=\"w3-button w3-dark-grey\" style=\"margin-left: 10%\" type=\"button\" value=\"Add To Borrow\" onclick=\"cart(" + b.getIsbn() + ", '" + b.getTitle() + "', " + b.getAmount() + ")\"/>");
            writer.write("<input class=\"w3-button w3-dark-grey\" style=\"margin-left: 5%\" type=\"button\" value=\"Info\" onclick=\"info(" + b.getIsbn() + ")\"/>");
            writer.write("</div>");
            writer.write("<div class=\"w3-twothird\">");
            writer.write("<h3><strong>" + b.getTitle() + "</strong></h3>");
            writer.write("<h4 style=\"color: blue\">" + b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName() + "</h4>");
            writer.write("<span class=\"fa fa-star w3-text-yellow w3-large\">");
            writer.write("<strong>");
            writer.write(b.getRating() == 0 ? "Not Rated" : b.getRating() + "");
            writer.write("</strong>");
            writer.write("</span>&nbsp; &nbsp;");
            writer.write("<span class=\"w3-large\">" + b.getCategory() + "</span><hr>");
            writer.write("<p style=\"height: 200px; overflow-y: auto\">");
            writer.write(b.getDescription() == null ? "No Description" : b.getDescription());
            writer.write("</p>");
            writer.write("</div>");
            writer.write("</div>");
        }
        writer.write("<hr><span style=\"margin-left: 25%\"></span>");
        if (pageindex > 1) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(1)\" value=\"First\"> ");
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex - 1) + ")\" value=\"Previous\"> ");
        }
        if (pageindex >= 3) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex - 2) + ")\" value=\"" + (pageindex - 2) + "\"> \n");
        }
        if (pageindex >= 2) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex - 1) + ")\" value=\"" + (pageindex - 1) + "\"> \n");
        }
        writer.write("<input type=\"button\" class=\"w3-button\" value=\"" + pageindex + " (Current page)\">\n");
        if (pageindex + 1 <= totalpage) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex + 1) + ")\" value=\"" + (pageindex + 1) + "\"> \n");
        }
        if (pageindex + 2 <= totalpage) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex + 2) + ")\" value=\"" + (pageindex + 2) + "\"> \n");
        }
        if (pageindex < totalpage) {
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + (pageindex + 1) + ")\" value=\"Next\"> \n");
            writer.write("<input type=\"button\" class=\"w3-button w3-dark-grey\" onclick=\"paging(" + totalpage + ")\" value=\"Last\">\n");
        }
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
