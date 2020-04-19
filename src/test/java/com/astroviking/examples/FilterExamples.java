package com.astroviking.examples;

import com.astroviking.domain.Gender;
import com.astroviking.domain.Person;
import com.astroviking.data.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExamples {

  @Test
  public void filterOnePredicate() {
    List<Person> people = MockData.getPeople();

    List<Person> males =
        people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .collect(Collectors.toList());

    males.forEach(System.out::println);
  }


  @Test
  public void filterMultiPredicate() {
    List<Person> people = MockData.getPeople();

    // Males over the age of 18
    List<Person> males =
            people.stream()
                    .filter(person -> person.getGender() == Gender.MALE && person.getAge() > 17)
                    .collect(Collectors.toList());

    males.forEach(System.out::println);
  }

  @Test
  public void filterWithPredicate() {
    List<Person> people = MockData.getPeople();

    Predicate<Person> femalePredicate = person -> person.getGender() == Gender.FEMALE;

    List<Person> females = people.stream().filter(femalePredicate).collect(Collectors.toList());

    females.forEach(System.out::println);

  }


}
