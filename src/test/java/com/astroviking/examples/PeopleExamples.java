package com.astroviking.examples;

import com.astroviking.loader.PersonLoader;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class PeopleExamples {

  @Test
  public void filterPersonByAge() {
    PersonLoader.getPeople().stream()
        .filter(person -> person.getAge() <= 18)  // Filter age <= 18
        .limit(10) // Gather first 10 people
        .collect(Collectors.toList()) // Collect to list
        .forEach(System.out::println);
  }
}
