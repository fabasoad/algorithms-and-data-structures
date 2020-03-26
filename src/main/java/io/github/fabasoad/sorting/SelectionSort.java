package io.github.fabasoad.sorting;

// O(n^2)
public class SelectionSort {

    public void sort(final int[] arr) {
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
}
