package io.github.fabasoad.sorting;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int a = getPivotIndex(arr, s, e);

        sort(arr, s, a - 1);
        sort(arr, a + 1, e);
    }

    private static int getPivotIndex(int[] arr, int s, int e) {
        int pivot = arr[e];

        int a = s;
        int b = e - 1;

        while (a <= b) {
            while (a <= b && arr[a] < pivot) {
                a++;
            }
            while (b >= a && arr[b] >= pivot) {
                b--;
            }
            swap(arr, a, a < b ? b : e);
        }

        return a;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[b];
        arr[b] = arr[a];
        arr[a] = t;
    }
}
