package com.fabasoad.testdata;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by efabizhevsky on 7/26/2017.
 */
public class TestDataGenerator {

    public static int[] randomSortedArray(int length) {
        int[] result = randomArray(length);
        Arrays.sort(result);
        return result;
    }

    public static int[] randomArray(int length) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(100);
        }
        return result;
    }

    public static Person binaryTree() {
        Person p = new Person("John");
        createChildren(p, 2);

        Iterator<Person> iterator = p.getChildren().iterator();
        createChildren(iterator.next(), 2);
        createChildren(iterator.next(), 2);

        createChildren(p.getChildren().iterator().next().getChildren().iterator().next(), 2);

        return p;
    }

    private static void createChildren(Person person, int count) {
        for (int i = 0; i < count; i++) {
            person.addChild(new Person(person.getName() + "_" + i));
        }
    }
}
