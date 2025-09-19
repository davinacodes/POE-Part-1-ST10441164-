package org.example;

public class Login {

    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    private  String storeUsername;
    private  String storePassword;
    private  String storePhoneNumber;

    public Login(String firstName, String lastName, String password, String phoneNumber, String username) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }


    public boolean checkUsername (String username) {

        if (username == null) return false;
        return username.contains("_") && username.length() <= 5 ;
    }

    public boolean checkPassword (String password) {

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        if (password.length() <8) return false;

        for (char c: password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialCharacter = true;
        }
        return hasUppercase && hasNumber && hasSpecialCharacter;


    }
    public boolean checkPhonenumber (String phoneNumber) {

        if (phoneNumber == null ) return false;

        String southAfricaStrict = "^\\+27\\d{9}$";

        String genericInternational = "^\\+\\d{1,3}\\d{1,10}$";

        return phoneNumber.matches(southAfricaStrict) || phoneNumber.matches(genericInternational);
    }

    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an _ and is no more than 5 characters in length.";
        }
        if (!checkPassword(password)) {
            return "Password is not correctly formatted; please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        if (!checkPhonenumber(phoneNumber)) {
            return "Phone number is incorrectly formatted or does not contain international code." ;
        }

        this.storeUsername = this.username;
        this.storePassword = this.password;
        this.storePhoneNumber = this.phoneNumber;

        return "User is registered successfully.";
    }

    public boolean loginUser (String username, String password) {
        if (storeUsername != null && storeUsername.equals(username) && storePassword.equals(password)) {
            return false;
        }
        return true;
    }


    public String loginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + " it is great having you back.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }


}
