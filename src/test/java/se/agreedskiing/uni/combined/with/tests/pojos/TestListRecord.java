package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.List;

public record TestListRecord(
  List<Integer> numbers,
  List<String> texts,
  List<Boolean> booleans
) {
  public static TestListRecord of(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    return new TestListRecord(numbers, texts, booleans);
  }
}
