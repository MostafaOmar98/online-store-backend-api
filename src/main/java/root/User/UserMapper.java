package root.User;

import java.sql.SQLException;

public interface UserMapper {
    public Boolean userExists(String username, String password) throws SQLException;
}
