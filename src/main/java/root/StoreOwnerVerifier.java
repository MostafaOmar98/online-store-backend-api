package root;

public class StoreOwnerVerifier {
    private Verifier verifier;

    StoreOwnerVerifier(){
        verifier = new Verifier();
    }

    private String verifySocialID(String socialID){
        if(socialID == null || socialID.isEmpty()){
            return "Error: Social ID cannot be empty";
        }
        return "OK";
    }

    public String verify(StoreOwner storeOwner){
        String status = verifier.verifyUserInfo(storeOwner.getUserInfo());
        if(!status.equals("OK"))
            return  status;

        status = verifySocialID(storeOwner.getSocialID());
        return status;
    }
    // TODO should exists() function(s) that checks whether the socialID exist in the database be added here?
}
