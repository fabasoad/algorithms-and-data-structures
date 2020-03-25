package io.github.fabasoad.sorting;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {
        var arr = new int[] { 1, 34, 2, 33, 3, 6, 66, 67, 37 };
        var arr1 = mergeSort(arr);
        System.out.println(Arrays.toString(arr1));
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

    private static int[] mergeSort(int[] a) {
        return mergeSort(0, a.length, a);
    }

    private static int[] mergeSort(int s, int e, int[] a) {
        if (e - s > 1) {
            int[] left = mergeSort(s, (s + e)/2, a);
            int[] right = mergeSort((s + e)/2, e, a);
            int[] res = new int[left.length + right.length];
            int l = 0, r = 0, i = 0;
            while (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    res[i] = left[l];
                    i++;
                    l++;
                } else {
                    res[i] = right[r];
                    i++;
                    r++;
                }
            }
            while (l < left.length) {
                res[i] = left[l];
                i++;
                l++;
            }
            while (r < right.length) {
                res[i] = right[r];
                i++;
                r++;
            }
            return res;
        } else {
            return new int[] { a[s] };
        }
    }
}
