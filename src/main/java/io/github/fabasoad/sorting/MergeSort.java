package io.github.fabasoad.sorting;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] a) {
        return mergeSort(a, 0, a.length);
    }

    private static int[] mergeSort(int[] a, int s, int e) {
        if (e - s > 1) {
            int[] left = mergeSort(a, s, (s + e) / 2);
            int[] right = mergeSort(a, (s + e) / 2, e);
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
