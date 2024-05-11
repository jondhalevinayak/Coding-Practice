package com.local.coding_practice.PasswordValidator;

public class InvalidPasswordException extends Exception {

    int passwordConditionViolated = 0;

    public InvalidPasswordException(int passwordConditionViolated) {
        super("Invalid Password! ");
        this.passwordConditionViolated = passwordConditionViolated;
    }

    public String printMessage() {

        switch (passwordConditionViolated) {
            case 1:
                return "Invalid Length";
            case 2:
                return "Password should not contains space";
            case 3:
                return "Password should contains at least one digit";
            case 4:
                return ("Password should contain at  least one special character");
            case 5:
                return ("Password should contain at least one uppercase letter(A-Z)");
            case 6:
                return ("Password should contain at least one lowercase letter(a-z)");
        }

        return "";
    }


}
