package io.github.fabasoad.search;

import java.util.Comparator;

public interface Search<T> {
  int find(T[] arr, T element, Comparator<T> comparator);
}
