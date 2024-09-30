package tobyspring.tobyhellospring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SortTest {

  @Test
  void sort() {
    //given
    Sort sort = new Sort();
    //when
    List<String> sortedList = sort.sortByLength(Arrays.asList("aa", "b"));
    //then
    assertThat(sortedList).isEqualTo(List.of("b", "aa"));
  }
}