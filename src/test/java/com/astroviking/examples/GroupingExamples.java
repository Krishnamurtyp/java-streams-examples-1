package com.astroviking.examples;

import com.astroviking.data.MockData;
import com.astroviking.domain.Gender;
import com.astroviking.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingExamples {

  @Test
  public void simpleGrouping() {
    List<Person> people = MockData.getPeople();

    Map<Gender, List<Person>> genderGroups =
        people.stream().collect(Collectors.groupingBy(Person::getGender));

    genderGroups.get(Gender.MALE).forEach(System.out::println);
  }

  @Test
  public void groupingAndCounting() {
    List<String> colors = Arrays.asList("Red", "Red", "Blue", "Blue", "Blue", "White");

    Map<String, Long> counting =
        colors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    counting.forEach((name, count) -> System.out.println(name + " -> " + count));
  }
}
