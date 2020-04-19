package com.astroviking.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

public class FindExamples {

  private final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  final Predicate<Integer> numberPredicate = n -> n > 5 && n < 10;

  @Test
  public void findAny() {
    int number = Arrays.stream(numbers).parallel().filter(n -> n < 10).findAny().orElse(0);
    System.out.println(number);
  }

  @Test
  public void findFirst() {
    int number = Arrays.stream(numbers).filter(numberPredicate).findFirst().orElse(0);
    System.out.println(number);
  }
}
