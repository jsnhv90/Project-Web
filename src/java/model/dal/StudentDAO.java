/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.BookBorrow;
import model.bean.Student;

/**
 *
 * @author vy dau khac
 */
public class StudentDAO extends DBContext<Student> {

    public StudentDAO() {
        super();
    }

    public Student getInfo(String username) {
        String query = "select [password], [first name], [last name], gender, "
                + "email, phone, birthdate, [address], [student id]\n"
                + " from [User] u inner join Student s on u.username = s.username"
                + " where u.username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(rs.getString("password"));
                student.setFirstName(rs.getString("first name"));
                student.setLastName(rs.getString("last name"));
                student.setMale(rs.getBoolean("gender"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setDob(rs.getDate("birthdate"));
                student.setAddress(rs.getString("address"));
                student.setStudentId(rs.getString("student id"));
                return student;
            }
        } catch (SQLException ex) {
            System.out.println("error when execute query");
        }
        return null;
    }

    public void borrowBooks(String username, Set<String> cart) {
        for (String isbn : cart) {
            borrowABook(username, isbn);
        }
    }

    public void borrowABook(String username, String isbn) {
        //update amount
        String query = "update Book set amount = "
                + "(select amount - 1 from Book where ISBN = ?)\n"
                + "where ISBN = ? and amount > 0";
        int rowEffect = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, isbn);
            statement.setString(2, isbn);
            rowEffect = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //only borrow when amount > 0, mean that rowAffect > 0
            if (rowEffect > 0) {
                //add to borrow table
                query = "INSERT INTO Borrow values(?, ? ,?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, isbn);
                statement.setString(2, username);
                Calendar cal = Calendar.getInstance();
                Date today = new Date(cal.getTimeInMillis());
                //return book after 7 days
                cal.add(Calendar.DATE, 1);
                Date returnDate = new Date(cal.getTimeInMillis());
                statement.setDate(3, today);
                statement.setDate(4, returnDate);
                statement.executeQuery();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<BookBorrow> getOverdueBooks(String username) {
        ArrayList<BookBorrow> overdue = new ArrayList<>();
        String query = "select b.ISBN, [borrowed date], [return date] from Book b inner join "
                + "Borrow br on b.ISBN = br.ISBN where username = ? and [return date] < GETDATE()";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BookBorrow bb = new BookBorrow();
                bb.setReturnDate(rs.getDate("return date"));
                bb.setIsbn(rs.getString("ISBN"));
                bb.setBorrowDate(rs.getDate("borrowed date"));
                overdue.add(bb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return overdue;
    }
}
