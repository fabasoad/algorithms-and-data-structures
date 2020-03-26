package io.github.fabasoad.sorting;

public class MergeSort {

    public int[] sort(int[] a) {
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
