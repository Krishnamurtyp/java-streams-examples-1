package com.astroviking.examples;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceExamples {

  final List<Integer> numbers = Arrays.asList(1, 5, 20, 100, 50, 20, 4, 5, 5, 5, 20, 20, 1);

  /**
   * Combines numbers together using reduce
   */
  @Test
  public void reduce() {
    Integer sum1 = numbers.stream().reduce(0, (a, b) -> a + b);

    System.out.println(sum1);

    Integer sum2 = numbers.stream().reduce(0, Integer::sum);

    System.out.println(sum2);
  }

  private final List<List<String>> arrayListOfNames =
      Arrays.asList(
          Arrays.asList("Mariam", "Alex", "Ismail"),
          Arrays.asList("John", "Alesha", "Andre"),
          Arrays.asList("Susy", "Ali"));

  @Test
  public void withoutFlapMap() {
    List<String> combinedNames =
        arrayListOfNames.stream()
            .reduce(
                new ArrayList<>(),
                (a, b) -> {
                  a.addAll(b);
                  return a;
                });

    combinedNames.forEach(System.out::println);
  }

  @Test
  public void flatMap() {
    List<String> names = arrayListOfNames.stream().flatMap(List::stream).collect(Collectors.toList());
    names.forEach(System.out::println);
  }
}
