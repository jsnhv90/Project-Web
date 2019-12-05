/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Administrator;

/**
 *
 * @author vy dau khac
 */
public class AdministratorDAO extends DBContext<Administrator> {

    public AdministratorDAO() {
        super();
    }

    public Administrator getInfo(String username) {
        String query = "select [password], [first name], [last name], gender, "
                + "email, phone, birthdate, [address], [position]\n"
                + " from [User] u inner join Administrator a on u.username = a.username"
                + " where u.username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Administrator admin = new Administrator();
                admin.setUsername(username);
                admin.setPassword(rs.getString("password"));
                admin.setFirstName(rs.getString("first name"));
                admin.setLastName(rs.getString("last name"));
                admin.setMale(rs.getBoolean("gender"));
                admin.setEmail(rs.getString("email"));
                admin.setPhone(rs.getString("phone"));
                admin.setDob(rs.getDate("birthdate"));
                admin.setAddress(rs.getString("address"));
                admin.setPosition(rs.getString("position"));
                return admin;
            }
        } catch (SQLException ex) {
            System.out.println("error when execute query");
        }
        return null;
    }
}
