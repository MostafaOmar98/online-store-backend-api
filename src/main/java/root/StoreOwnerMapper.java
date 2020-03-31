package root;

import java.sql.PreparedStatement;
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
}
