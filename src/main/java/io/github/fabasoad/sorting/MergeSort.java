package io.github.fabasoad.sorting;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {

  private final Comparator<T> comparator;

  public MergeSort(final Comparator<T> comparator) {
    this.comparator = comparator;
  }

  @Override
  public T[] sort(final T[] a) {
    return a != null && a.length > 1
      ? mergeSort(a, 0, a.length)
      : a;
  }

  @SuppressWarnings("unchecked")
  private T[] mergeSort(T[] a, int s, int e) {
    if (e - s > 1) {
      T[] left = mergeSort(a, s, (s + e) / 2);
      T[] right = mergeSort(a, (s + e) / 2, e);
      T[] res = (T[]) Array.newInstance(a.getClass().getComponentType(), left.length + right.length);
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
      T[] res = (T[]) Array.newInstance(a.getClass().getComponentType(), 1);
      res[0] = a[s];
      return res;
    }
  }
}
