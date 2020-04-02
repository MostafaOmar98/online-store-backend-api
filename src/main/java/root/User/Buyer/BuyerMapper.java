package root.User.Buyer;

import root.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerMapper { // TODO use Springboot to do row mapping
    private static PreparedStatement bindParam(Buyer buyer, String query) throws SQLException {
        PreparedStatement statement = DatabaseConnection.prepare(query);

        statement.setString(1, buyer.getUsername());
        statement.setString(2, buyer.getEmail());
        statement.setString(3, buyer.getPassword());
        statement.setString(4, buyer.getName());
        statement.setString(5, buyer.getAddress());

        return statement;
    }

    public static void insert(Buyer buyer) throws SQLException {
        String query = "INSERT INTO buyer (username, email, password, name, address) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = bindParam(buyer, query);
        statement.execute();
    }

    private static Buyer fetchObject(ResultSet resultSet) throws SQLException {
        if(resultSet.next() == false)
            return null;
        return new Buyer(resultSet.getInt("id"), resultSet.getString("username"),
                         resultSet.getString("email"), resultSet.getString("password"),
                         resultSet.getString("name"), resultSet.getString("address"));
    }

    public static Buyer select(String username) throws SQLException{
        String query = "SELECT * FROM buyer WHERE username=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        return fetchObject(result);
    }
}
