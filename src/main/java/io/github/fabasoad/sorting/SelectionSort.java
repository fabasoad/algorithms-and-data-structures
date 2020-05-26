package io.github.fabasoad.sorting;

import java.util.Comparator;

// O(n^2)
public class SelectionSort<T> implements Sort<T> {

  private final Comparator<T> comparator;

  public SelectionSort(final Comparator<T> comparator) {
    this.comparator = comparator;
  }

  @Override
  public T[] sort(final T[] arr) {
    if (arr != null) {
      for (int i = 0; i < arr.length; i++) {
        var min = i;
        for (int j = i + 1; j < arr.length; j++) {
          if (comparator.compare(arr[min], arr[j]) > 0) {
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
    return arr;
  }
}
