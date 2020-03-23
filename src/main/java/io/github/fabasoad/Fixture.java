package io.github.fabasoad;

import java.util.Arrays;
import java.util.Random;

public class Fixture {

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
}
