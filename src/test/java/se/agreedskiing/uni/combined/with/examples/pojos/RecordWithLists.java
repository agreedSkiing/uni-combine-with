package se.agreedskiing.uni.combined.with.examples.pojos;

import java.util.List;

public record RecordWithLists(
  List<Integer> numbers,
  List<String> texts,
  List<Boolean> booleans
) {
  public static RecordWithLists of(
    final List<Integer> numbers,
    final List<String> texts,
    final List<Boolean> booleans
  ) {
    return new RecordWithLists(numbers, texts, booleans);
  }
}
