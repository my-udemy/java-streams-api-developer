package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  /**
   * Given a list of number
   * get the smallest one
   * */
  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
    assertThat(1).isEqualTo(min);
  }

  /**
   * Given a list of numbers
   * get the greatest one
   * */
  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
    assertThat(100).isEqualTo(max);
  }
}
