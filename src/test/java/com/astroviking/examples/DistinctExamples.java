package com.astroviking.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctExamples {

  final List<Integer> numbers = Arrays.asList(1, 5, 20, 100, 50, 20, 4, 5, 5, 5, 20, 20, 1);

  @Test
  public void distinct() {
    List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
    assertEquals(6, distinctNumbers.size());
    distinctNumbers.forEach(System.out::println);
  }

  @Test
  public void distinctWithSet() {
    // You can bypass call to distinct by using Set structure
    Set<Integer> distinctNumbers = numbers.stream().collect(Collectors.toSet());
    assertEquals(6, distinctNumbers.size());
    distinctNumbers.forEach(System.out::println);
  }
}
