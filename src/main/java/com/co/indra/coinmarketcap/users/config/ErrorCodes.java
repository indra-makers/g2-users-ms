package com.co.indra.coinmarketcap.users.config;

public enum ErrorCodes {

    USER_MAIL_UNIQUE("That mail is already in use", "001"),
    USERNAME_UNIQUE("That username is taken. Try another.", "002");

    String message;
    String code;

    ErrorCodes(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
