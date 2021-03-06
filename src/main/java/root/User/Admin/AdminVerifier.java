package root.User.Admin;

import root.User.Verifier;

import java.sql.SQLException;

public class AdminVerifier {
    private Verifier verifier;

    AdminVerifier(){
        verifier = new Verifier();
    }

    private String verifyKey(String key) throws SQLException {
        if(key == null || key.isEmpty()){
            return "Error: Key cannot be empty";
        }

        Integer key_id = AdminMapper.getKeyId(key);
        if(key_id == null){
            return "Error: Key does not exist";
        }
        if (AdminMapper.select(key_id) != null) {
            return "Error: Key is reserved";
        }
        return "OK";
    }

    private Boolean usernameExists(String username) throws SQLException {
        return AdminMapper.select(username) != null;
    }

    private boolean emailExists(String email) throws SQLException {
        return AdminMapper.selectByEmail(email) != null;
    }

    public String verify(Admin admin) throws SQLException {
        String status = verifier.verifyUserInfo(admin.getUserInfo());
        if (!status.equals("OK")) {
            return status;
        }
        if (usernameExists(admin.getUsername())) {
            return "Error: Username already exists";
        }
        if (emailExists(admin.getEmail())) {
            return "Error: Email already exists";
        }
        return verifyKey(admin.getKey());
    }

}
