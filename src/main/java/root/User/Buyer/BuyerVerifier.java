package root.User.Buyer;

import root.User.Verifier;

import java.sql.SQLException;

public class BuyerVerifier {
    private Verifier verifier;

    BuyerVerifier(){
        verifier = new Verifier();
    }

    private String verifyAddress(String address){
        if (address == null || address.isEmpty()) {
            return "Error: Address cannot be empty";
        }
        return "OK";
    }

    private Boolean usernameExists(String username) throws SQLException {
        return BuyerMapper.select(username) != null;
    }

    private Boolean emailExists(String email) throws SQLException {
        return BuyerMapper.selectByEmail(email) != null;
    }

    public String verify(Buyer buyer) throws SQLException {
        String status = verifier.verifyUserInfo(buyer.getUserInfo());
        if (!status.equals("OK")) {
            return status;
        }
        if (usernameExists(buyer.getUsername())) {
            return "Error: Username already exists";
        }
        if (emailExists(buyer.getEmail())) {
            return "Error: Email already exists";
        }
        return verifyAddress(buyer.getAddress());
    }
}
