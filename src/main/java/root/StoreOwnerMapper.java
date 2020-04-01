package root;

import org.apache.catalina.Store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreOwnerMapper {
    private static PreparedStatement bindParam(StoreOwner storeOwner, String query) throws SQLException {
        PreparedStatement statement = DatabaseConnection.prepare(query);

        statement.setString(1, storeOwner.getUserInfo().getUsername());
        statement.setString(2, storeOwner.getUserInfo().getEmail());
        statement.setString(3, storeOwner.getUserInfo().getPassword());
        statement.setString(4, storeOwner.getUserInfo().getName());
        statement.setString(5, storeOwner.getSocialID());

        return statement;
    }

    public static void insert(StoreOwner storeOwner) throws SQLException {
        String query = "INSERT INTO store_owner (username, email, password, name, social_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = bindParam(storeOwner, query);
        statement.execute();
    }

    private static StoreOwner fetchObject(ResultSet resultSet) throws SQLException {
        if(resultSet.next() == false)
            return null;
        return new StoreOwner(resultSet.getInt("id"), resultSet.getString("username"),
                              resultSet.getString("email"), resultSet.getString("password"),
                              resultSet.getString("name"), resultSet.getString("social_id"));
    }

    public static StoreOwner select(String username) throws SQLException {
        String query = "SELECT * FROM store_owner WHERE username=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        return fetchObject(result);
    }
}
