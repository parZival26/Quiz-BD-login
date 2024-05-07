package Back;

import java.util.ArrayList;

public class VerifyUser {
    public static boolean verify(String nombre, String contraseña) {
        try {
            ArrayList<User> users = DBManager.getUsers();

            for (User user : users) {
                if (user.getUsername().equals(nombre) && user.getPassword().equals(contraseña)) {
                    DBManager.insertLog(user);
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
