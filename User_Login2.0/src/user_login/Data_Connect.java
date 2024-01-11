
package user_login;
import java.sql.*;


/**
 *
 * @author Valeria
 */
public class Data_Connect {
   
    public static Connection Data_Con() {
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
    }
    public static void main(String[] args) {
        Data_Con();
    }
}
