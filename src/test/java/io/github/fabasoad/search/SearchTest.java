package io.github.fabasoad.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SearchTest {

  @ParameterizedTest
  @MethodSource("providerForTestSearch")
  void testSearch(final Fixture fixture, final Search<Integer> search) {
    assertEquals(fixture.index, search.find(fixture.data, fixture.element));
  }

  private static Stream<Arguments> providerForTestSearch() {
    final Collection<SearchTest.Fixture> fixtureList = Arrays.asList(
        new SearchTest.Fixture(new Integer[]{-10, -9, -8, -2, 0, 1}, 1, 5),
        new SearchTest.Fixture(new Integer[]{-10, -9, -2, -2, 0, 1}, -2, 3),
        new SearchTest.Fixture(new Integer[]{-10, -2, -2, 0, 1}, -2, 2),
        new SearchTest.Fixture(new Integer[]{-10, -9, -8, -2, 0, 1}, 11, -1),
        new SearchTest.Fixture(new Integer[0], 2, -1),
        new SearchTest.Fixture(null, 10, -1)
    );
    final Collection<Search<Integer>> sortList = Collections.singletonList(
        new BinarySearch<>(Integer::compareTo)
    );
    return fixtureList
        .stream()
        .flatMap(f -> sortList
            .stream()
            .map(s -> Arguments.of(f, s)));
  }

  private static class Fixture {

    private final Integer[] data;
    private final Integer element;
    private final int index;

    public Fixture(final Integer[] data, final Integer element, final int index) {
      this.data = data;
      this.element = element;
      this.index = index;
    }

    @Override
    public String toString() {
      return String.format("%s, %s = %s", Arrays.toString(data), element, index);
    }
  }
}
