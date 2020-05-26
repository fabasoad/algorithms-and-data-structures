package io.github.fabasoad.sorting;

import java.util.Comparator;

// O(n^2)
public class InsertionSort<T> implements Sort<T> {

  private final Comparator<T> comparator;

  public InsertionSort(final Comparator<T> comparator) {
    this.comparator = comparator;
  }

  @Override
  public T[] sort(final T[] arr) {
    if (arr != null) {
      for (int i = 1; i < arr.length; i++) {
        for (int j = i; j > 0; j--) {
          if (comparator.compare(arr[j], arr[j - 1]) < 0) {
            var temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
          }
        }
      }
    }
    return arr;
  }
}
