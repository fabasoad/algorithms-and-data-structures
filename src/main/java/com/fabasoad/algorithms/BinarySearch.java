package com.fabasoad.algorithms;

import com.fabasoad.testdata.TestDataGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by efabizhevsky on 7/26/2017.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data = TestDataGenerator.randomSortedArray(50);
        find(data, data[33]);
        find(data, new Random().nextInt(100));
        find(data, new Random().nextInt(100));
        find(data, new Random().nextInt(100));
    }

    public static void find(int[] data, int x) {
        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("Element to find: " + x);

        int i = -1;
        if (data != null) {
            int low = 0, high = data.length, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (x == data[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x < data[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        System.out.println(i == -1 ? "Element not found" : "Element found at position " + i);
    }
}
