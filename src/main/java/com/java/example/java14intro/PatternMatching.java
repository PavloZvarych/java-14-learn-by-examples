package com.java.example.java14intro;

import lombok.Builder;
import lombok.Getter;

/**
 * Official documentation: https://openjdk.java.net/jeps/305
 */
public class PatternMatching {

    public static void main(String... args) {
    }

    /**
     * Standard way of instanceof, class casting and variable assignment.
     */
    private static void printIfInstanceOfStringStandardWay(Object x) {
        if(x instanceof String) {
            String person = (String) x;
            System.out.println(person);
        }
    }

    /**
     * Or we can create person variable through pattern matching.
     * If x is instanceof String, then person variable will be created.
     */
    private static void printIfInstanceOfStringPatternMatching(Object x) {
        if(x instanceof String person) {
            System.out.println(person);
        }
    }

    /**
     * Auxiliary class to be send to getUsersAddress(Object x) method.
     * Scroll down.
     */
    @Builder
    @Getter
    static class User {
        private final String address;
    }

    /**
     * Pattern matching can be used to write one line checks.
     * If x is instance of User, user variable is created and address returned.
     */
    private static String getUsersAddress(Object x) {
//        if (x instanceof User) {
//            return ((User) x).getAddress();
//        }
//        return "";
        return x instanceof User user ? user.getAddress() : "";
    }

    /**
     * If on the left of && we create pattern variable, then this variable can be used on the right.
     */
    private static boolean validateAddress(Object x) {
        return x instanceof String address && address.length() < 20;
    }

    /**
     * Pattern variable cannot be used on the right of ||,
     * because it means that x is not instance of String.
     */
    private static boolean validateName(Object x, boolean ignoreCase) {
        return x instanceof String name || /*name.length() < 10 && */ ignoreCase;
    }

}
