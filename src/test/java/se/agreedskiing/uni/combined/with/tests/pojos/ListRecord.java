package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.List;

public record ListRecord(
  List<Integer> numbers,
  List<String> texts,
  List<Boolean> booleans
) {
  public static ListRecord of(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    return new ListRecord(numbers, texts, booleans);
  }
}