package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  /**
   * Iterate and print out a sequence of 10 numbers
   * using an imperative approach
   * and a declarative approach with range and rangeClosed functions
   * */
  @Test
  public void range() throws Exception {
    System.out.println("imperative");
    for (int i = 0; i < 10 ; i++) {
      System.out.println(i);
    }
    System.out.println("exclusive range");
    // print out from 0 to 9
    IntStream.range(0,10).forEach(index -> System.out.println(index));
    System.out.println("inclusive range");
    // print out from 0 to 10
    IntStream.rangeClosed(0,10).forEach(index -> System.out.println(index));
  }

  /**
   * Iterate and print out elements of a list
   * */
  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size())
            .forEach(index -> System.out.println(people.get(index)));
  }

  /**
   * Iterate over a sequence of infinite numbers
   * filter even numbers
   * get and print out the first 20 numbers
   * */
  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, operand -> operand + 1)
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}