package Function;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author jiaqisun
 */
public class Map_connect {
    
    public static Connection Map_Con() {
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:uwomap.db");
            System.out.println("SUCCED");
            return con;
        }
        catch(Exception e){
            System.out.println("fail"+ e);
            return null;
        }
    }public static void main(String[] args) {
        Map_Con();
    }
   
}
