/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;

/**
 *
 * @author vy dau khac
 */
public class Administrator extends User implements Serializable{
    private String position;

    public Administrator() {
        super();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
