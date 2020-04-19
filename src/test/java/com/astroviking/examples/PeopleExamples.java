package com.astroviking.examples;

import com.astroviking.data.MockData;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class PeopleExamples {

  @Test
  public void filterPersonByAge() {
    MockData.getPeople().stream()
        .filter(person -> person.getAge() <= 18) // Filter age <= 18
        .limit(10) // Gather first 10 people
        .collect(Collectors.toList()) // Collect to list
        .forEach(System.out::println);
  }
}
