package com.example.languagelearning;

// AuthenticationManager.java
public class LogInMan {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public static boolean isValidCredentials(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
