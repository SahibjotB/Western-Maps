package user_login;

/**
 *
 * @author Valeria
 */
public class User_Login {

    
    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
