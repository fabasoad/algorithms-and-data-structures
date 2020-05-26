package io.github.fabasoad.search;

import java.util.Comparator;

public class BinarySearch<T> implements Search<T> {

  private final Comparator<T> comparator;

  public BinarySearch(final Comparator<T> comparator) {
    this.comparator = comparator;
  }

  @Override
  public int find(final T[] arr, final T element) {
    int i = -1;
    if (arr != null) {
      int low = 0, high = arr.length, mid;
      while (low < high) {
        mid = (low + high) / 2;
        if (comparator.compare(element, arr[mid]) == 0) {
          i = mid;
          break;
        } else {
          if (comparator.compare(element, arr[mid]) < 0) {
            high = mid;
          } else {
            low = mid + 1;
          }
        }
      }
    }

    return i;
  }
}
