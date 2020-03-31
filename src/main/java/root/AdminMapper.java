package root;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper {
    private static PreparedStatement bindParam(Admin admin, String query, Integer key_id) throws SQLException{
        PreparedStatement statement = DatabaseConnection.prepare(query);

        statement.setString(1, admin.getUsername());
        statement.setString(2, admin.getEmail());
        statement.setString(3, admin.getPassword());
        statement.setString(4, admin.getName());
        statement.setInt(5, key_id);

        return statement;
    }

    public static void insert(Admin admin) throws SQLException{
        String query = "INSERT INTO admin (username, email, password, name, key_id) " +
                        "VALUES (?, ?, ?, ?, ?)";
        Integer key_id = getKeyId(admin.getKey());
        assert(key_id != null); // this should always be true because insert is never called without verification
        PreparedStatement statement = bindParam(admin, query, key_id);
        statement.execute();
    }

    private static Admin fetchObject(ResultSet resultSet) throws SQLException {
        if(resultSet.next() == false)
            return null;
        return new Admin(resultSet.getInt("id"), resultSet.getString("username"),
                                resultSet.getString("email"), resultSet.getString("password"),
                                resultSet.getString("name"), getKeyValue(resultSet.getInt("key_id")));
    }

    public static Admin select(Integer key_id) throws SQLException {
        String query = "SELECT * FROM admin WHERE key_id=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setInt(1, key_id);

        ResultSet result = statement.executeQuery();
        return fetchObject(result);
    }

    public static Integer getKeyId(String key) throws SQLException{
        String query = "SELECT id FROM admin_keys WHERE key_value=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setString(1, key);

        ResultSet result = statement.executeQuery();
        Integer key_id = null;
        if(result.next()){
            key_id = result.getInt("id");
        }
        return key_id;
    }

    public static String getKeyValue(Integer id) throws SQLException{
        String query = "SELECT key_value FROM admin_keys WHERE id=?";

        PreparedStatement statement = DatabaseConnection.prepare(query);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        String key_value = null;
        if(result.next()){
            key_value = result.getString("key_value");
        }
        return key_value;
    }
}
