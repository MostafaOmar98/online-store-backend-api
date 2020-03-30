package root;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BuyerBehavior extends UserBehavior {
    @Override
    public void register(RegistrationHolder regHolder) {
        // TODO verify
        StoreOwner storeOwner = new StoreOwner(regHolder.getUserInfo(), regHolder.getSocialID());

        // TODO the following code inside a mapper
        Connection con = DatabaseConnection.getInstance();

        String query = "INSERT INTO shop_owner (username, email, password, name, social_id) " +
                        "VALUES (?, ?, ?, ?, ?)";
        try{ // TODO fix function chains
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, storeOwner.getUserInfo().getName());
            preparedStatement.setString(2, storeOwner.getUserInfo().getEmail());
            preparedStatement.setString(3, storeOwner.getUserInfo().getPassword());
            preparedStatement.setString(4, storeOwner.getUserInfo().getName());
            preparedStatement.setString(5, storeOwner.getSocialID());

            preparedStatement.execute();
        }catch (Exception e){e.printStackTrace();}
    }
}
