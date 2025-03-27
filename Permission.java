/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy_stock_management_system;

import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class Permission {
    public boolean permission(String username){
        try{
        Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "root", "Mych0ice@12345");
                String sql = "SELECT post  FROM login WHERE username=?";
                PreparedStatement stm = con.prepareStatement(sql); 
                stm.setString(1, username);
                ResultSet r = stm.executeQuery();
                r.next();
                String post = r.getString(1);
                if(post.equals("admin")){
                    return true;
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
                return false;
        }
        
    
    
}

