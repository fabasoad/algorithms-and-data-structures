package io.github.fabasoad.sorting;

import java.util.Comparator;

import static io.github.fabasoad.arrays.ArrayUtils.newArray;

public class MergeSort<T> implements Sort<T> {

    @Override
    public T[] sort(final T[] a, final Comparator<T> comparator) {
        return mergeSort(a, 0, a.length, comparator);
    }

    private T[] mergeSort(T[] a, int s, int e, final Comparator<T> comparator) {
        if (e - s > 1) {
            T[] left = mergeSort(a, s, (s + e) / 2, comparator);
            T[] right = mergeSort(a, (s + e) / 2, e, comparator);
            T[] res = newArray(left.length + right.length);
            int l = 0, r = 0, i = 0;
            while (l < left.length && r < right.length) {
                if (comparator.compare(left[l], right[r]) < 0) {
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
            return newArray(1, a[s]);
        }
    }
}
