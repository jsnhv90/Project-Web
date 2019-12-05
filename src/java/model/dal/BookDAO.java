/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Author;
import model.bean.Book;
import model.bean.BookComment;
import model.bean.Publisher;

/**
 *
 * @author vy dau khac
 */
public class BookDAO extends DBContext<Book> {

    public BookDAO() {
        super();
    }

    public ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();
        String query = "SELECT category FROM Category";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public ArrayList<String> getAllLanguages() {
        ArrayList<String> languages = new ArrayList<>();
        String query = "select [language] from [Language]";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                languages.add(rs.getString("language"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return languages;
    }

    public ArrayList<String> getAllFormats() {
        ArrayList<String> formats = new ArrayList<>();
        String query = "select [format] from [Format]";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                formats.add(rs.getString("format"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formats;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String query = "select ISBN, title, [first name] + ' ' + [last name] as "
                + "'author name', [publisher name], category,\n"
                + "[language], [format], [page], amount, rating from Book b \n"
                + "inner join Author a on b.[author id] = a.[author id]\n"
                + "inner join Publisher p on b.[publisher id] = p.[publisher id]";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("title"));

                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public ArrayList<Book> getAllBooksDescription(int pageindex, int pagesize) {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY isbn asc) as rownum, isbn, \n"
                + "title, [author id], category, rating, [description], image ,amount FROM Book)\n"
                + " tblBook WHERE rownum BETWEEN ? AND ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, (pageindex * pagesize - pagesize) + 1);
            statement.setInt(2, pageindex * pagesize);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                int authorId = rs.getInt("author id");
                AuthorDAO authorDAO = new AuthorDAO();
                book.setAuthor(authorDAO.getFullNameById(authorId));
                //set author
                book.setCategory(rs.getString("category"));
                book.setRating(rs.getFloat("rating"));
                book.setDescription(rs.getString("description"));
                book.setAmount(rs.getInt("amount"));
                book.setImage(rs.getString("image"));
                
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    
    public int totalRecord() {
        int total = -1;
        try {
            String query = "SELECT COUNT(*) as total FROM Book";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalRecordFilter(String title, String author,
            String category, String publisher, String language, String format) {
        int total = -1;
        HashMap<Integer, String> param = new HashMap();
        //build query
        String filter_query = "SELECT ROW_NUMBER() OVER (ORDER BY isbn asc) as rownum FROM Book b \n"
                + "inner join Author a on b.[author id] = a.[author id]\n"
                + "inner join Publisher p on b.[publisher id] = p.[publisher id] WHERE 1=1";

        int queryParamIndex = 0;
        if (title != null && title.length() > 0) {
            filter_query += " and title like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, title);
        }
        if (author != null && author.length() > 0) {
            filter_query += " and (a.[first name] + ' ' + a.[last name]) like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, author);
        }
        if (category != null && category.length() > 0 && !category.equals("any")) {
            filter_query += " and category = ?";
            queryParamIndex++;
            param.put(queryParamIndex, category);
        }
        if (publisher != null && publisher.length() > 0) {
            filter_query += " and [publisher name] like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, publisher);
        }
        if (language != null && language.length() > 0 && !language.equals("any")) {
            filter_query += " and [language] = ?";
            queryParamIndex++;
            param.put(queryParamIndex, language);
        }
        if (format != null && format.length() > 0 && !format.equals("any")) {
            filter_query += " and [format] = ?";
            queryParamIndex++;
            param.put(queryParamIndex, format);
        }

        String query = "SELECT COUNT(*) as total FROM (" + filter_query + ") tblBook";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            for (int i = 1; i <= queryParamIndex; i++) {
                statement.setString(i, param.get(i));
            }
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ArrayList<Book> filterBookDescription(String title, String author,
            String category, String publisher, String language, String format,
            int pageindex, int pagesize) {
        ArrayList<Book> books = new ArrayList<>();
        HashMap<Integer, String> param = new HashMap();
        //build query
        String filter_query = "SELECT ROW_NUMBER() OVER (ORDER BY isbn asc) as rownum, ISBN, \n"
                + "title, b.[author id], category, rating, b.[description],b.image as 'a image', amount FROM Book b \n"
                + "inner join Author a on b.[author id] = a.[author id]\n"
                + "inner join Publisher p on b.[publisher id] = p.[publisher id] WHERE 1=1";

        int queryParamIndex = 0;
        if (title != null && title.length() > 0) {
            filter_query += " and title like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, title);
        }
        if (author != null && author.length() > 0) {
            filter_query += " and (a.[first name] + ' ' + a.[last name]) like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, author);
        }
        if (category != null && category.length() > 0 && !category.equals("any")) {
            filter_query += " and category = ?";
            queryParamIndex++;
            param.put(queryParamIndex, category);
        }
        if (publisher != null && publisher.length() > 0) {
            filter_query += " and [publisher name] like '%' + ? + '%'";
            queryParamIndex++;
            param.put(queryParamIndex, publisher);
        }
        if (language != null && language.length() > 0 && !language.equals("any")) {
            filter_query += " and [language] = ?";
            queryParamIndex++;
            param.put(queryParamIndex, language);
        }
        if (format != null && format.length() > 0 && !format.equals("any")) {
            filter_query += " and [format] = ?";
            queryParamIndex++;
            param.put(queryParamIndex, format);
        }

        String query = "SELECT * FROM (" + filter_query + ")\n"
                + " tblBook WHERE rownum BETWEEN ? AND ?";
        try {
            //set param
            PreparedStatement statement = conn.prepareStatement(query);
            for (int i = 1; i <= queryParamIndex; i++) {
                statement.setString(i, param.get(i));
            }
            queryParamIndex++;
            statement.setInt(queryParamIndex, (pageindex * pagesize - pagesize) + 1);
            queryParamIndex++;
            statement.setInt(queryParamIndex, pageindex * pagesize);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("title"));
                int authorId = rs.getInt("author id");
                AuthorDAO authorDAO = new AuthorDAO();
                book.setAuthor(authorDAO.getFullNameById(authorId));
                //set author
                book.setCategory(rs.getString("category"));
                book.setRating(rs.getFloat("rating"));
                book.setDescription(rs.getString("description"));
                book.setAmount(rs.getInt("amount"));
                book.setImage(rs.getString("a image"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }

    public Book getBookByIsbn(String isbn) {
        String query = "select title, category, [language], [format], [page], amount, rating,\n"
                + "b.[description] as 'book description',b.image as 'book image', [first name], [last name], birthdate, country,\n"
                + " a.[description] as 'author description',a.image as 'author image', [publisher name], [address], phone \n"
                + " from Book b inner join Author a on b.[author id] = a.[author id]\n"
                + "inner join Publisher p on b.[publisher id] = p.[publisher id] where ISBN = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, isbn);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Book b = new Book();
                b.setIsbn(isbn);
                b.setTitle(rs.getString("title"));
                Author a = new Author();
                a.setFirstName(rs.getString("first name"));
                a.setLastName(rs.getString("last name"));
                a.setDob(rs.getDate("birthdate"));
                a.setCountry(rs.getString("country"));
                a.setDescription(rs.getString("author description"));
                a.setImage(rs.getString("author image"));
                b.setAuthor(a);
                b.setCategory(rs.getString("category"));
                b.setLanguage(rs.getString("language"));
                b.setFormat(rs.getString("format"));
                b.setPage(rs.getInt("page"));
                b.setAmount(rs.getInt("amount"));
                b.setRating(rs.getFloat("rating"));
                b.setImage(rs.getString("book image"));
                b.setDescription(rs.getString("book description"));
                Publisher p = new Publisher();
                p.setName(rs.getString("publisher name"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                b.setPublisher(p);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateRating(String isbn) {
        String query = "update Book set rating = "
                + "(select AVG(rate) from Comment where ISBN = ?) where ISBN = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, isbn);
            statement.setString(2, isbn);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<BookComment> getComments(String isbn) {
        ArrayList<BookComment> comments =new ArrayList<>();
        String query = "select username, rate, [rating date], comment from Comment where ISBN = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, isbn);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                BookComment cmt = new BookComment();
                cmt.setIsbn(isbn);
                cmt.setUsername(rs.getString("username"));
                cmt.setRate(rs.getFloat("rate"));
                cmt.setRatingDate(rs.getDate("rating date"));
                cmt.setComment(rs.getString("comment"));
                comments.add(cmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }
}
