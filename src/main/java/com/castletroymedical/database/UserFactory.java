package hbillsystem.src.main.java.com.castletroymedical.database;
public class UserFactory {
    public User getUser(String userType){

        if(userType.equalsIgnoreCase("patient")) {
            return new Patient();

        } else if (userType.equalsIgnoreCase("admin")){
            return new Admin();
        }

        return null;
    }
}
