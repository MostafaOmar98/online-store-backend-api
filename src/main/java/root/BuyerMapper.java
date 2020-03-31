package root;

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
}
