package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {
  /**
   * Given a list of random people,
   * filter the ones whose age is under 18
   * and limit the result to 10 elements
   * and print out the result lists
   * */
  @Test
  public void imperativeApproach() throws IOException {
    // creates a list of random people
    List<Person> people = MockData.getPeople();
    // declares an empty list to collect people under 18
    List<Person> peopleUnder18 = new ArrayList<>();
    int limit = 0;
    // loop through the list of people
    for(int i=0; i<people.size(); i++){
      Person currentPerson = people.get(i);
      if(currentPerson.getAge().intValue()<=18){
        if(limit <=10 ){
          // if the current person is under 18
          // then add the person the result list
          peopleUnder18.add(currentPerson);
          limit= limit+1;
        }
      }
    }

    // loop through the result list
    // and print out people under 18 one by one
    for(Person under18 : peopleUnder18){
      System.out.println(under18);
    }
  }

  /**
   * Given a list of random people,
   * filter the ones whose age is under 18
   * and limit the result to 10 elements
   * and print out the result lists
   * */
  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    // creates a list of random people
    ImmutableList<Person> people = MockData.getPeople();
    // converts the input list as a stream of elements
    people.stream()
            // filter people whose age is under 18
            .filter(person -> person.getAge()<=18)
            // collects the first 10 people
            .limit(10)
            // converts the result stream to a list
            .collect(Collectors.toList())
            // loop through result list elements
            // and print out every person
            .forEach(person -> System.out.println(person));
  }
}
