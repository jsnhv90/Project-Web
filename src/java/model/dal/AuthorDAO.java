/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Author;

/**
 *
 * @author vy dau khac
 */
public class AuthorDAO extends DBContext<Author> {

    public AuthorDAO() {
        super();
    }

    public Author getFullNameById(int id) {
        Author author = new Author();
        String query = "select [first name], [last name] from Author where [author id] = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                author.setId(id);
                author.setFirstName(rs.getString("first name"));
                author.setLastName(rs.getString("last name"));
                return author;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }
}
