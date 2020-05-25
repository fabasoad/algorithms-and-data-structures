package io.github.fabasoad.sorting;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

    @Override
    public T[] sort(final T[] arr, final Comparator<T> comparator) {
        sort(arr, 0, arr.length - 1, comparator);
        return arr;
    }

    private void sort(final T[] arr, int s, int e, final Comparator<T> comparator) {
        if (s >= e) {
            return;
        }

        int a = getPivotIndex(arr, s, e, comparator);

        sort(arr, s, a - 1, comparator);
        sort(arr, a + 1, e, comparator);
    }

    private int getPivotIndex(T[] arr, int s, int e, final Comparator<T> comparator) {
        T pivot = arr[e];

        int a = s;
        int b = e - 1;

        while (a <= b) {
            while (a <= b && comparator.compare(arr[a], pivot) < 0) {
                a++;
            }
            while (b >= a && comparator.compare(arr[b], pivot) >= 0) {
                b--;
            }
            swap(arr, a, a < b ? b : e);
        }

        return a;
    }

    private void swap(T[] arr, int a, int b) {
        final T t = arr[b];
        arr[b] = arr[a];
        arr[a] = t;
    }
}
