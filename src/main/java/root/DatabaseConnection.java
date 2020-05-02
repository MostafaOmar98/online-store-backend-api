package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getInstance(){
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_store", "root", "");
            }
            catch (Exception e){e.printStackTrace();}
        }
        return connection;
    }
    public static PreparedStatement prepare(String query) throws SQLException {
        Connection con = getInstance();
        return con.prepareStatement(query);
    }
}
