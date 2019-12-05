package model.dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.BookBorrow;
import model.bean.BookComment;
import model.bean.Student;
import model.bean.User;

/**
 *
 * @author vy dau khac
 */
public class UserDAO extends DBContext<User> {

    /*access table User must use [User] on query*/
    public UserDAO() {
        super();
    }

    //check whether user "username" param on DB have same password as "password" param
    public boolean checkPassword(String username, String password) {
        try {
            String query = "SELECT [password] FROM [User] WHERE [username] = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                //check password correct or incorrect
                return password.equals(rs.getString("password"));
            } else {
                //username is not exist
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("error when check password with username " + username);
            return false;
        }
    }

    public boolean isStudent(String username) {
        try {
            String query = "SELECT [student id] FROM [Student] WHERE [username] = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            //if have result mean that exist student with "username"
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("error when check student with username " + username);
            return false;
        }
    }

    public void comment(String isbn, String username, float rate, String comment) {
        //add comment
        String query = "SELECT rate from Comment where isbn = ? and username = ?";
        Date today = new Date(Calendar.getInstance().getTimeInMillis());
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, isbn);
            statement.setString(2, username);
            ResultSet rs = statement.executeQuery();
            //if username had commend with this book then update
            if (rs.next()) {
                System.out.println("update");
                query = "update Comment set rate = ?, comment = ?, [rating date] = ?"
                        + " where ISBN = ? and username = ?";
                statement = conn.prepareStatement(query);
                statement.setFloat(1, rate);
                statement.setString(2, comment);
                statement.setDate(3, today);
                statement.setString(4, isbn);
                statement.setString(5, username);
                statement.executeUpdate();
            } else {
                //otherwise insert new row
                query = "INSERT INTO Comment values(?, ?, ?, ?, ?)";
                statement = conn.prepareStatement(query);
                statement.setString(1, isbn);
                statement.setString(2, username);
                statement.setFloat(3, rate);
                statement.setString(4, comment);
                statement.setDate(5, today);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<BookBorrow> getBorrows(String username) {
        ArrayList<BookBorrow> borrows = new ArrayList<>();
        String query = "select ISBN, [borrowed date], [return date] from Borrow where username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BookBorrow bb = new BookBorrow();
                bb.setIsbn(rs.getString("ISBN"));
                bb.setUsername(username);
                bb.setBorrowDate(rs.getDate("borrowed date"));
                bb.setReturnDate(rs.getDate("return date"));
                borrows.add(bb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return borrows;
    }

    public ArrayList<BookComment> getComments(String username) {
        ArrayList<BookComment> comments = new ArrayList<>();
        String query = " select ISBN, rate, comment, [rating date] from Comment where username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BookComment cmt = new BookComment();
                cmt.setIsbn(rs.getString("ISBN"));
                cmt.setUsername(username);
                cmt.setRate(rs.getFloat("rate"));
                cmt.setRatingDate(rs.getDate("rating date"));
                cmt.setComment(rs.getString("comment"));
                comments.add(cmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }
    // --------- dark

    public ArrayList<BookBorrow> getBorrowsAll() {
        ArrayList<BookBorrow> borrows = new ArrayList<>();
        String query = "select * from Borrow ORDER BY [borrowed date] DESC ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BookBorrow bb = new BookBorrow();
                bb.setIsbn(rs.getString("ISBN"));
                bb.setUsername(rs.getString("username"));
                bb.setBorrowDate(rs.getDate("borrowed date"));
                bb.setReturnDate(rs.getDate("return date"));
                borrows.add(bb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return borrows;
    }

    public ArrayList<BookComment> getCommentsAll() {
        ArrayList<BookComment> comments = new ArrayList<>();
        String query = " select * from Comment ORDER BY [rating date] DESC";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BookComment cmt = new BookComment();
                cmt.setIsbn(rs.getString("ISBN"));
                cmt.setUsername(rs.getString("username"));
                cmt.setRate(rs.getFloat("rate"));
                cmt.setRatingDate(rs.getDate("rating date"));
                cmt.setComment(rs.getString("comment"));
                comments.add(cmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public void update(String username, String password, String phone, String address, String email) {
        String query = " update [User] set [password] = ?, phone= ?, [address] = ?, [email] = ?\n"
                + "  where username = ?";
        try {
            PreparedStatement s = conn.prepareStatement(query);
            s.setString(1, password);
            s.setString(2, phone);
            s.setString(3, address);
            s.setString(4, email);
            s.setString(5, username);
            s.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(Student c) {
        try {
            PreparedStatement ps = conn.prepareCall("insert into [User] values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getFirstName());
            ps.setString(4, c.getLastName());
            ps.setBoolean(5, c.isMale());
            ps.setString(6, c.getEmail());
            ps.setString(7, c.getPhone());
            ps.setDate(8, c.getDob());
            ps.setString(9, c.getAddress());
            ps.execute();
            ps = conn.prepareCall("insert into Student values (?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getStudentId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
