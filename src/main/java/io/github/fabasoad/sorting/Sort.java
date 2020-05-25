package io.github.fabasoad.sorting;

import java.util.Comparator;

public interface Sort<T> {

    T[] sort(T[] arr, Comparator<T> comparator);
}
