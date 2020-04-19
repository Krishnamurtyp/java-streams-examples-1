package com.astroviking.examples;

import com.astroviking.data.MockData;
import com.astroviking.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoinStringExamples {

  @Test
  public void joinStrings() {
    List<String> names = Arrays.asList("One", "Two", "Three");

    String combined = names.stream().collect(Collectors.joining(", "));

    System.out.println(combined);
    assertEquals("One, Two, Three", combined);
  }

  @Test
  public void customCollector() {
    List<Person> people = MockData.getPeople();

    List<String> emails =
        people.parallelStream()
            .map(Person::getEmail)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    emails.forEach(System.out::println);
  }
}
