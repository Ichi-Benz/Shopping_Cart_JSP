/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Owner
 */
public class UserBean {
    
    String name, password;

    public UserBean() {
    }

    
    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void DeleteItem(String item) throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2","Root","Root");
        PreparedStatement ps = conn.prepareStatement("DELETE FROM ITEMS WHERE ITEM_NAME='" + item + "'");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public void AddItem(String item, String itemDesc, int stock, double price, int id, String image, String category) 
            throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2","Root","Root");
        
        PreparedStatement ps = conn.prepareStatement("INSERT INTO ITEMS (ITEM_NAME,ITEM_DESCRIPTION,ITEM_PRICE"
                + ",ITEM_STOCK,ITEM_ID,ITEM_IMAGE,ITEM_CATEGORIES)"
                + "VALUES('"+item+"','"+itemDesc+"',"+price+","+stock+","+id+",'"+ image +"','" + category + "')");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public void UpdateItem(String item, String value, String category) 
            throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assignment2","Root","Root");
            String v = "";
            if(category.equals("ITEM_PRICE")){
                Double.parseDouble(v = value);
            }else if(category.equals("ITEM_STOCK")){
                Integer.parseInt(v = value);
            }else{

                v = "'"+value+"'";
            }
        PreparedStatement ps = 
                conn.prepareStatement("UPDATE ITEMS SET "
                        + ""+category+"="+v+" WHERE ITEM_NAME='"+item+"'");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
