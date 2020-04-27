package com.java.example.java14intro;

import lombok.Setter;
import org.javatuples.Pair;

import java.lang.reflect.RecordComponent;

/**
 *  Record examples: new type declaration.
 *  Official documentation: https://openjdk.java.net/jeps/359
 */
public class Records {

    public static void main(String[] args) {
    }

}

/**
 *  Record with no components (arguments).
 *  Check out the compiled Base.class.
 *  Call toString(), equals() and hashCode() methods from main(String[] args).
 */
record Base() {}

/**
 *  Record with one component (argument) example.
 *  Check out the compiled Bill.class.
 *  Instance member commented because it is not allowed in records.
 *  No setter will be generated as records supposed to be immutable.
 */
@Setter
record Bill(String address) {
//    private final String x;
}

/**
 *  Record can have static fields, static and instance methods
 */
record Restaurant () {

    private static int instanceCounter = 0;

    public Restaurant {
        instanceCounter++;
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }

    public void testInstanceVariableAccessibility() {
        System.out.println("instance method are allowed in records");
    }
}

/**
 *  Record's generated methods can be overridden (ctrl + o in IntelliJ)
 */
record Person(String firstName, String secondName) {
    public Person {
        if (firstName.length() < 4 || secondName.length() < 4) {
            throw new IllegalArgumentException("first or second name length is less then 4");
        }
    }

    @Override
    public int hashCode() {
        return 18;
    }
}

/**
 *  Record can have constructors:
 *  - compact;
 *  - canonical;
 *  - custom.
 *  alt + Insert for generation in IntelliJ
 *
 */
record Animal(String x, String y) {
    /**
     *  Compact constructor example.
     *  Field initialization is implicitly initialized.
     *  No need for this.x = x.
     *  @param x - foo field
     *  @param y - foo field
     */
    public Animal {
        y = "y";
    }
}

/**
 *  Auxiliary class to be used with generic record example below
 */
class Triangle {
    String shapeName = "triangle";
}

/**
 *  Records can be generic
 *  @param <T> - generic type
 */
record Shape<T>(T shape) {
}

/**
 *  Nested records are declared static
 */
class ExampleWithNestedRecord {
    record NestedRecord(){}
}

/**
 *  New methods has been added to the Class to support new Record type:
 *  - isRecord() and
 *  - getRecordComponents().
 */
class NewReflectionApi {

    /**
     * RecordComponent class has information about accessor method, annotations, field name
     * @param clazz - record to get components from
     * @return record components array
     */
    public static RecordComponent[] getRecordComponents(Class clazz) {
        if (clazz.isRecord()) {
            return clazz.getRecordComponents();
        }
        return new RecordComponent[]{};
    }
}

/**
 * Tuples is a collection of elements of different type.
 * Tuples are alternative to java records.
 * Java records has few advantages over tuples:
 * - records have meaningful class and members names;
 * - class can support state validation in their constructor.
 */
class RecordsAlternative {
    public static void main(String[] args) {
        Pair<String, String> personTuple = new Pair<>("John", "Doe");
        System.out.println(personTuple);
        Person personRecord = new Person("John", "Doe");
        System.out.println(personRecord);
    }
}
