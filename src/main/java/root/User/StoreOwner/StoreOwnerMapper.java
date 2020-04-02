package root.User.StoreOwner;

import root.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<StoreOwner> selectAll() throws SQLException {
        String query = "SELECT * from store_owner";

        PreparedStatement statement = DatabaseConnection.prepare(query);

        ResultSet resultSet = statement.executeQuery();
        List<StoreOwner> list = new ArrayList<StoreOwner>();
        while (true) {
            StoreOwner sw = fetchObject(resultSet);
            if (sw == null)
                break;
            list.add(sw);
        }
        return list;
    }

    public static StoreOwner selectByEmail(String email) throws SQLException {
        String query = "SELECT * FROM store_owner WHERE email=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setString(1, email);

        ResultSet result = statement.executeQuery();
        return fetchObject(result);
    }
}
