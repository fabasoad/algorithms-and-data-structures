package io.github.fabasoad.sorting;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {
        var arr = new int[] { 66, 1, 34, 2, 33, 3, 6, 66, 67, 37 };
        System.out.println(Arrays.toString(new MergeSort().sort(arr)));
    }
}
