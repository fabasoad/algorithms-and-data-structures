package io.github.fabasoad.sorting;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

  private final Comparator<T> comparator;

  public QuickSort(final Comparator<T> comparator) {
    this.comparator = comparator;
  }

  @Override
  public T[] sort(final T[] arr) {
    if (arr != null && arr.length > 1) {
      sort(arr, 0, arr.length - 1);
    }
    return arr;
  }

  private void sort(final T[] arr, int s, int e) {
    if (s >= e) {
      return;
    }

    int a = getPivotIndex(arr, s, e);

    sort(arr, s, a - 1);
    sort(arr, a + 1, e);
  }

  private int getPivotIndex(T[] arr, int s, int e) {
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
