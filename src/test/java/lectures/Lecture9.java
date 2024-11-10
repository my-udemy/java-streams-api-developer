package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import org.junit.Test;

public class Lecture9 {

  /**
   * Given an array of {@link Integer}
   * accumulates the sum of numbers
   * and return a result value
   * */
  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    // the reduce function takes 2 arguments
    // the init value
    // the function to sum the accumulated value plus the current one
    Integer sum = Arrays.stream(integers)
            .reduce(0, (a,b) -> a+b);
    System.out.println(sum);
    sum = Arrays.stream(integers).reduce(0, (a,b) -> Integer.sum(a,b));
    System.out.println(sum);
  }
}

