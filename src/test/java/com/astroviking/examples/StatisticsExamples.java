package com.astroviking.examples;

import com.astroviking.domain.Gender;
import com.astroviking.domain.Person;
import com.astroviking.data.MockData;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsExamples {

  @Test
  public void count() {
    List<Person> people = MockData.getPeople();

    long count = people.stream().filter(person -> person.getGender() == Gender.MALE).count();

    assertEquals(446, count);
  }

  @Test
  public void min() {
    List<Person> people = MockData.getPeople();

    int count =
        people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .mapToInt(Person::getAge)
            .min()
            .orElse(0);

    assertEquals(1, count);
  }

  @Test
  public void max() {
    List<Person> people = MockData.getPeople();

    int count =
        people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .mapToInt(Person::getAge)
            .max()
            .orElse(0);

    assertEquals(100, count);
  }

  @Test
  public void average() {
    List<Person> people = MockData.getPeople();

    double count =
        people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .mapToDouble(Person::getAge)
            .average()
            .orElse(0);

    assertEquals(51.37394957983193, count);
  }

  @Test
  public void sum() {
    List<Person> people = MockData.getPeople();

    int sum = people.stream().filter(person -> person.getGender() == Gender.FEMALE).mapToInt(Person::getAge).sum();

    assertEquals(25348, sum);
  }

  @Test
  public void summaryStatistics() {
    List<Person> people = MockData.getPeople();

    IntSummaryStatistics intSummaryStatistics = people.stream().mapToInt(Person::getAge).summaryStatistics();

    System.out.println(intSummaryStatistics);
  }
}
