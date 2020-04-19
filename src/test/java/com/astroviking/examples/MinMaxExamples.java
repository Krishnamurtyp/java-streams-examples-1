package com.astroviking.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxExamples {

  final List<Integer> numbers = Arrays.asList(1, 5, 20, 100, 50, 61, 20, 4);

  @Test
  public void min() {

    // Finds 1, the minimum value
    Integer min = numbers.stream().min(Comparator.naturalOrder()).get();

    assertEquals(1, min);
    System.out.println(min);
  }

  @Test
  public void max() {
    Integer max = numbers.stream().max(Comparator.naturalOrder()).get();

    assertEquals(100, max);
    System.out.println(max);
  }
}
