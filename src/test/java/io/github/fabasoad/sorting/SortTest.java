package io.github.fabasoad.sorting;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

  @ParameterizedTest
  @MethodSource("providerForTestSort")
  void testSort(final Fixture fixture, final Sort<Integer> sort) {
    assertArrayEquals(fixture.expected, sort.sort(fixture.unsorted));
  }

  private static Stream<Arguments> providerForTestSort() {
    final Collection<Fixture> fixtureList = Arrays.asList(
        new Fixture(new Integer[]{9, 7, 88, -2, 23, 0, -2}, new Integer[]{-2, -2, 0, 7, 9, 23, 88}),
        new Fixture(new Integer[]{-10, -9, -8, -2, 0, 1}, new Integer[]{-10, -9, -8, -2, 0, 1}),
        new Fixture(new Integer[]{4, 3, 1, -9, -99, -102}, new Integer[]{-102, -99, -9, 1, 3, 4}),
        new Fixture(new Integer[0], new Integer[0]),
        new Fixture(null, null)
    );
    final Collection<Sort<Integer>> sortList = Arrays.asList(
        new InsertionSort<>(Integer::compareTo),
        new MergeSort<>(Integer::compareTo),
        new QuickSort<>(Integer::compareTo),
        new SelectionSort<>(Integer::compareTo)
    );
    return fixtureList
        .stream()
        .flatMap(f -> sortList
            .stream()
            .map(s -> Arguments.of(f, s)));
  }

  private static class Fixture {

    private final Integer[] unsorted;
    private final Integer[] expected;

    private Fixture(Integer[] unsorted, Integer[] expected) {
      this.unsorted = unsorted;
      this.expected = expected;
    }

    @Override
    public String toString() {
      return String.format("[%s, %s]", Arrays.toString(unsorted), Arrays.toString(expected));
    }
  }
}
