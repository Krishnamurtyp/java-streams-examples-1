package com.astroviking.examples;

import com.astroviking.domain.Person;
import com.astroviking.data.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreamExamples {

  @Test
  public void rangeExclusive() {
    // Prints 0 to 9
    IntStream.range(0, 10).forEach(System.out::println);
  }

  @Test
  public void rangeInclusive() {
    // Prints 0 to 10
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  @Test
  public void intStreamPeople() {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size()).forEach(index -> System.out.println(people.get(index)));
  }

  @Test
  public void iterate() {
    // Prints 1 to 10
    IntStream.iterate(1, operand -> operand + 1).limit(10).forEach(System.out::println);
  }

  @Test
  public void iterateEven() {
    // Prints first ten even number, starting from 0
    IntStream.iterate(0, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(10)
        .forEach(System.out::println);
  }
}
