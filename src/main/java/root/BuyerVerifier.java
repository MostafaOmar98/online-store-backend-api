package root;

public class BuyerVerifier {
    private Verifier verifier;

    BuyerVerifier(){
        verifier = new Verifier();
    }

    private String verifyAddress(String address){
        if(address == null || address.isEmpty()){
            return "Error: Address cannot be empty";
        }
        return "OK";
    }

    public String verify(Buyer buyer){
        String status = verifier.verifyUserInfo(buyer.getUserInfo());
        if(!status.equals("OK"))
            return  status;

        status = verifyAddress(buyer.getAddress());
        return status;
    }
}
