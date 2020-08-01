package com.java.example.java14intro;

import lombok.Setter;
import org.javatuples.Pair;

import java.lang.reflect.RecordComponent;
import java.util.Objects;

/**
 *  Official documentation: https://openjdk.java.net/jeps/359
 */
public class Records {

    public static void main(String[] args) {
    }

}

/**
 * We can create a class with instance fields, constructor, toString(), hashCode(), equals() and getters.
 * That requires a lot of boilerplate code.
 */
final class RecordsExample {
    private final String name;
    private final String shape;

    public RecordsExample(String name, String shape) {
        this.name = name;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "RecordsExample{" +
                "name='" + name + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shape);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordsExample that = (RecordsExample) o;
        return name.equals(that.name) &&
                shape.equals(that.shape);
    }

    public String getName() {
        return name;
    }

    public String getShape() {
        return shape;
    }
}

/**
 * In jdk 14 we can have the same result with records.
 * Check out the compiled RecordExample class.
 */
record RecordExample(String name, String shape) {}

/**
 *  The record can be without components (arguments).
 */
record Base() {}

/**
 *  Instance fields are not allowed in records.
 *  Even if we try, no setter will be generated as records supposed to be shallowly immutable.
 */
@Setter
record Bill(String address) {
//    private final String x;
}

/**
 *  A record can have static fields, static and instance methods.
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
 * Records can have a compact constructor with no parameters.
 * When we use a compact constructor we do not need to assign input parameters to private members.
 * Record's generated methods can be overridden (ctrl + o in Intellij).
 */
record Person(String firstName, String secondName) {

    public Person {
        if (firstName.length() < 4 || secondName.length() < 4) {
            throw new IllegalArgumentException("first or second name length is less then 4");
        }
//        this.firstName = firstName;
//        this.secondName = secondName;
    }

    @Override
    public int hashCode() {
        return 18;
    }
}

/**
 * We can also generate a canonical constructor.
 * Canonical constructor has all parameters.
 * Initialization of fields required.
 * alt + Insert for generation in Intellij.
 */
record Animal(String x, String y) {

    public Animal(String x, String y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * Records have a custom constructor, that is not required to have all parameters,
 * but has to call a canonical constructor.
 */
record Administrator(String firstName, String secondName) {

    public Administrator(String firstName) {
        this(firstName, null);
    }
}

/**
 *  Auxiliary class to be used with generic record example below.
 */
class Triangle {
    String shapeName = "triangle";
}

/**
 *  Records can be generic.
 *  We can create record the same way as a class:
 *  Shape<Triangle> triangleShape = new Shape<>(new Triangle());
 */
record Shape<T>(T shape) {
}

/**
 *  Nested records are declared static.
 *  Check generated code out.
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
     * RecordComponent class has information about accessor method, annotations, field name and so on.
     */
    public static RecordComponent[] getRecordComponents(Class clazz) {
        if (clazz.isRecord()) {
            return clazz.getRecordComponents();
        }
        return new RecordComponent[]{};
    }
}

/**
 * A tuple is a collection of elements of different (not necessarily the same) type
 * Tuples are an alternative to java records.
 * Java records have a few advantages over tuples:
 * - records have meaningful class and members names;
 * - a class can support state validation in their constructor.
 */
class RecordsAlternative {
    public static void main(String[] args) {
        Pair<String, String> personTuple = new Pair<>("John", "Doe");
        System.out.println(personTuple);
        Person personRecord = new Person("John", "Doe");
        System.out.println(personRecord);
    }
}
