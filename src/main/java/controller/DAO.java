/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Billboard;

/**
 *
 * @author Asus
 */
public class DAO {
    
    public ArrayList<Billboard> getListBillboard() {
        ArrayList<Billboard> list = new ArrayList<>();
        Billboard b = new Billboard();
                b.setBillboardId(1); 
                b.setUserId(1); 
                b.setMessage("bb no1"); 
                b.setInformation("bb info 1"); 
                b.setBackgroundColor("white 1"); 
                b.setFontColor("black 1"); 
               
                b.setPicture("pic 1");
                
        list.add(b);
        return list;
    }

    
    
}
