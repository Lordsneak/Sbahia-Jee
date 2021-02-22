package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    static Connection dbLink = null;

    // Connexion
    public static Connection getConnect() throws ClassNotFoundException, SQLException {
    	Class.forName("org.postgresql.Driver");
    	
        String url = "jdbc:postgresql://localhost:5432/SBahia";
        String dbUser = "postgres";
        String dbPass = "admin";

        // TimeZone : ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        
        try {
            dbLink = DriverManager.getConnection(url, dbUser, dbPass);
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return dbLink;
    }




}