/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Billboard implements Serializable {
    private  String message, information, backgroundColor, fontColor,  picture;
    private int billboardId, userId;
    private Date createdAt, updateAt;
    

    public Billboard(String message, String information, String backgroundColor, String fontColor, int billboardId, int userId, Date createdAt, Date updateAt, String picture) {
        this.message = message;
        this.information = information;
        this.backgroundColor = backgroundColor;
        this.fontColor = fontColor;
        this.picture = picture;
        this.billboardId = billboardId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        
    }
    
    public Billboard() {
        
    }
    
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getBillboardId() {
        return billboardId;
    }

    public void setBillboardId(int billboardId) {
        this.billboardId = billboardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    
}
