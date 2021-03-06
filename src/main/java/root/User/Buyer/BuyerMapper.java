package root.User.Buyer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import root.DatabaseConnection;
import root.User.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerMapper implements UserMapper { // TODO use Springboot to do row mapping
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

    public static List<Buyer> selectAll() throws SQLException {
        String query = "SELECT * from buyer";

        PreparedStatement statement = DatabaseConnection.prepare(query);

        ResultSet resultSet = statement.executeQuery();
        List<Buyer> list = new ArrayList<>();
        while (true) {
            Buyer buyer = fetchObject(resultSet);
            if (buyer == null)
                break;
            list.add(buyer);
        }
        return list;
    }

    public static Buyer selectByEmail(String email) throws SQLException {
        String query = "SELECT * FROM buyer WHERE email=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setString(1, email);

        ResultSet result = statement.executeQuery();
        return fetchObject(result);
    }

    @Override
    public Boolean userExists(String username, String password) throws SQLException{
        Buyer buyer = select(username);
        return buyer != null && new BCryptPasswordEncoder().matches(password, buyer.getPassword());
    }
}
