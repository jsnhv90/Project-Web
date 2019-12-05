package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Student;
import model.dal.UserDAO;

/**
 *
 * @author Jason
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.removeAttribute("error");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.sendRedirect("Reg.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        UserDAO udao = new UserDAO();
        String uid = request.getParameter("uid");
        if (udao.isStudent(uid)) {
            request.setAttribute("error", "Account has existed!!! Please choose other username");
            request.getRequestDispatcher("Reg.jsp").forward(request, response);
            return;
        }
        String pwd = request.getParameter("pwd");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        boolean gender = request.getParameter("gender").equals("male");
        String phone = request.getParameter("phone");
        Date dob = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String customerid = request.getParameter("id");
        Student c = new Student(uid, pwd, fname, lname, gender, email, phone, dob, address, customerid);
        udao.register(c);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<script>"
                    + "alert('Register Success!!!.You will go to login page after 1 seconds');"
                    + "setTimeout(function () {"
                    + "window.location.href = 'LoginView.jsp';"
                    + "}, 1000);"
                    + "</script>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
