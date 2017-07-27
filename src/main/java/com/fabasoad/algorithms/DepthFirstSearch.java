package com.fabasoad.algorithms;

import com.fabasoad.testdata.Person;
import com.fabasoad.testdata.TestDataGenerator;

import java.util.function.Consumer;

/**
 * Created by efabizhevsky on 7/26/2017.
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        Person person = TestDataGenerator.binaryTree();
        invoke(person, p -> System.out.println(p.getName()));
    }

    private static void invoke(Person p, Consumer<Person> consumer) {
        if (p != null && consumer != null) {
            consumer.accept(p);
            for (Person child : p.getChildren()) {
                invoke(child, consumer);
            }
        }
    }
}
