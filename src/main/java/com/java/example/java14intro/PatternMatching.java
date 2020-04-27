package com.java.example.java14intro;

import lombok.Builder;
import lombok.Getter;

/**
 * Used methods exemplify java 14 pattern matching use.
 * Official documentation: https://openjdk.java.net/jeps/305
 */
public class PatternMatching {

    public static void main(String... args) {
    }

    /**
     * Replace with pattern variable
     * @param x - string to be printed
     */
    private static void printIfInstanceOfString(Object x) {
        if(x instanceof String) {
            String x1 = (String) x;
            System.out.println(x1);
        }
    }

    /**
     * Use pattern matching and simplify it to one line return statement
     * @param x - user
     * @return user's address if input parameter is instanceof User
     */
    private static String getUsersAddress(Object x) {
        if (x instanceof User) {
            return ((User) x).getAddress();
        }
        return "";
    }

    /**
     * If x is instanceof String, pattern variable can be used on the right of &&
     * @param x - user's address
     * @return true if user's address is < 20
     */
    private static boolean validateAddress(Object x) {
        return x instanceof String address && address.length() < 20;
    }

    /**
     * Pattern variable cannot be used on the right of ||,
     * because it means that x is not instance of String.
     * @param x - a foo name
     * @param ignoreCase - foo parameter
     * @return true if x is instance of String or ignoreCase parameter is true
     */
    private static boolean validateName(Object x, boolean ignoreCase) {
        return x instanceof String name || /*name.length() < 10 && */ ignoreCase;
    }

}

/**
 * Auxiliary class for demo purpose.
 */
@Builder
@Getter
class User {
    private final String address;
}
