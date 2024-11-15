package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  /**
   * Given a List<Car>
   * filter the ones whose price is less than 1000 USD
   * and collect the result in a new List<Car>
   * and print out the new List<Car>.
   * */
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<Car> filterPredicate = car -> car.getPrice() < 1000;
    List<Car> carsUnder1000 = cars.stream()
            .filter(filterPredicate)
            .collect(Collectors.toList());
    carsUnder1000.stream().forEach(car -> System.out.println(car));
  }

  /**
   * Given a List<Person>
   * transform every {@link Person} into a {@link PersonDTO} object
   * and collect the result in a new List<PersonDTO>
   * and expect that the new List<PersonDTO> size is equal the original List<Person>
   * */
  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream().map(person -> {
      PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
      return dto;
    }).collect(Collectors.toList());
    dtos.stream().forEach(personDTO -> System.out.println(personDTO));
    assertThat(dtos.size()).isEqualTo(1000);
  }

  /**
   * Given a List<Car>
   * transform {@link Car#getPrice()} into a {@link Double}
   * and computes the average price
   * and returns a double value
   * */
  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .getAsDouble();
    System.out.println(averagePrice);
    assertThat(52693.19979).isEqualTo(averagePrice);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



