/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author vy dau khac
 */
public class Student extends User implements Serializable {

    private String studentId;

    public Student() {
        super();
    }

    public Student(String username, String password, String firstName, String lastName, boolean male, String email, String phone, Date dob, String address, String studentId) {
        super(username, password, firstName, lastName, male, email, phone, dob, address);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
