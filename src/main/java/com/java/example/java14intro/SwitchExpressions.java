package com.java.example.java14intro;

/**
 * In jdk 14 enhanced switch statements and switch expressions were added as a standard language feature.
 * In jdk 12 and 13 it was a preview language feature.
 * This class designed to help a user to understand switch expressions and why they were needed.
 * Official documentation: https://openjdk.java.net/jeps/361
 */
public class SwitchExpressions {

    /**
     * Main method to be used to call private methods of this class
     * @param args - any additional arguments from console
     */
    public static void main(String[] args) {
    }

    /**
     * What is the problem with the existing switch statements?
     * Problem #1: they are error-prone.
     * A user might forget to add a break statement.
     * This will lead to an unexpected result.
     * @param cellularOperator - specify cellular operator name
     */
    private static void printInternetPackageForCellularOperator(String cellularOperator) {
        switch (cellularOperator) {
            case "virgin mobile":
            case "orange":
                System.out.println("15 GB");
                break;
            case "lynca mobile":
                System.out.println("11 GB");
            case "vodaphone":
                System.out.println("5 GB");
                break;
            case "viking":
                System.out.println("12 GB");
                break;
            default:
                System.out.println("unknown cellular operator");
        }
    }

    /**
     * Enhanced switch statements were introduced.
     * Only expressions on the right of -> will be executed.
     * This solved the problem #1 mentioned above.
     * @param cellularOperator - cellular operator name
     */
    private static void printPriceOfBusinessSubscriptionForCellularOperator(String cellularOperator) {
        switch (cellularOperator) {
            case "virgin mobile", "orange" -> System.out.println("15$");
            case "lynca" -> System.out.println("20$");
            case "vodaphone" -> System.out.println("10$");
            case "viking" -> System.out.println("12$");
            default -> System.out.println("unknown cellular operator");
        }
    }

    /**
     * What is the problem with the existing switch statements?
     * Problem #2: variable defined inside one arm has a scope of an entire block.
     * Another arm/case cannot use the same variable name.
     * @param animal - name of the animal
     */
    private static void printClassOfAnimal(String animal) {
        switch (animal) {
            case "cat":
                int classNumber = 1;
                System.out.println(classNumber);
                break;
            case "dog":
//                int classNumber = 2;
                System.out.println("classNumber variable is already defined in the first arm");
                break;
            case "tiger":
//                int teclassNumbermp = 3;
                System.out.println("the same as in the second arm: variable defined");
        }
    }

    /**
     * Enhanced switch statements solve problem #2 mentioned above.
     * A variable inside one arm has a scope of this arm.
     * @param animal - name of the animal
     */
    private static void checkRegistrationNumberForAnimal(String animal) {
        switch (animal) {
            case "cat" -> {
                int temp = 1234;
                System.out.println(temp);
            }
            case "dog" -> {
                int temp = 2456;
                System.out.println("animal registration number: " + temp);
            }
        }
    }

    /**
     * Switch expression example.
     * Default case is required if case do not use enum.
     * For enum example look at printNameAssociatedWithId(Numbers) method below.
     * @param animal - domestic animal name
     */
    private static void printDomesticAnimalClass(String animal) {
        int animalClass = switch (animal) {
            case "dog" -> 1;
            case "cat" -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + animal);
        };
        System.out.println("animal class is " + animalClass);
    }

    /**
     * Switch expression example in System.out.println() function
     * @param x - number name
     */
    private static void printAssociatedNumber(String x) {
        System.out.println(switch (x) {
            case "one" -> 1;
            case "two" -> 2;
            default -> 777;
        });
    }

    /**
     * Jdk 14 introduced 'yield' statement to return value.
     * 'yield' is a restricted identifier and no class can be named that way.
     * Switch expression must either produce value or throw exception.
     * If you try to comment yield statement compiler will complain.
     * @param x - argument to check in switch expression
     */
    private static void printAssociatedClassWithAnimal(String x) {
        int animalClass = switch (x) {
            case "one" -> {
                System.out.println("first arm");
                yield 1;
            }
            case "two" -> {
                System.out.println("second arm");
                yield 2;
            }
            default -> 3;
        };
        System.out.println("animal class is:" + animalClass);
    }

    /**
     * Switch expression can use a traditional representation with colon label ":".
     * @param x - number representation name
     */
    private static void printAnimalClassificationName(String x) {
        int animalClass = switch (x) {
            case "one":
                System.out.println("first arm");
                yield 1;
            case "two":
                System.out.println("second arm");
                yield 2;
            default:
                yield 3;
        };
        System.out.println("animal class is:" + animalClass);
    }

    /*
        Open yield-name-collision.txt example file.
        Copy code here to find out the answer.
     */


    /**
     * Auxiliary enum to be used in printNameAssociatedWithId(Numbers) method
     */
    private enum Numbers {
        ONE,
        TWO,
        THREE,
        FOUR
    }

    /**
     * Default case is not required in case of enum.
     * If omitted it will be added by compiler.
     * It is not even recommended to add default case, in order to throw exception to indicate unexpected value.
     * Have a look at the compiled method.
     * @param id - id of a user
     */
    private static void printNameAssociatedWithId(Numbers id) {
        String name = switch (id) {
            case ONE -> "Tomas";
            case TWO -> "John";
            case THREE -> "Peter";
            default -> "The name";
        };
        System.out.println(name);
    }

}
