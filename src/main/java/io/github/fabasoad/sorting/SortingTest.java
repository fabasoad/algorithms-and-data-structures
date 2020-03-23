package io.github.fabasoad.sorting;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {
        var arr = new int[] { 1, 34, 2, 33, 3, 6 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // O(n^2)
    private static void selectionSort(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            var min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min > i) {
                var temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // O(n^2)
    private static void insertionSort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
