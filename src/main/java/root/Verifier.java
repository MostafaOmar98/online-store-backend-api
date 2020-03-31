package root;

public class Verifier { // TODO return improved status objects OR enum
    private Boolean isValidUsername(String username){
        return (username != null) && (username.length() > 5 && username.length() <= 16);
    }

    private Boolean isValidPassword(String password){
        return (password != null) && (password.length() > 8 && password.length() <= 32);
    }

    private Boolean isValidEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email != null && email.matches(regex);
    }

    private Boolean isValidName(String name){
        return (name != null) && !name.isEmpty();
    }

    public String verifyUserInfo(UserInfo info){
        if(!isValidUsername(info.getUsername())){
            return "Error: username cannot be empty and must be between 5 and 16 characters";
        }
        if(!isValidPassword(info.getPassword())){
            return "Error: password cannot be empty and must be between 8 and 32 characters";
        }
        if(!isValidEmail(info.getEmail())){
            return "Error: invalid email";
        }
        if(!isValidName(info.getName())){
            return "Error: name cannot be empty";
        }
        return "OK";
    }
    // TODO should exists() function(s) that checks whether a username/email exist in the database (ALL TABLES) be added here?
}
