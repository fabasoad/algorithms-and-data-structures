package io.github.fabasoad.arrays;

import java.util.Arrays;

public class ArrayUtils {
  @SafeVarargs
  public static <E> E[] newArray(int length, E... array) {
    return Arrays.copyOf(array, length);
  }
}
