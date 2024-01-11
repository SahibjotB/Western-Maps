
package user_login;
import java.sql.*;


/**
 *
 * @author Valeria
 */
public class Data_Connect {
    Connection con = null;
    
    public static Connection Data_Con() {
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:DataBase_Login.db");
            System.out.println("SUCCED");
            return con;
        }
        catch(Exception e){
            System.out.println("fail"+ e);
            return null;
        }
    }
}
