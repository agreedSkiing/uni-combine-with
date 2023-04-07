package se.agreedskiing.uni.combined.with.examples.pojos;

public record SimpleRecord(int number, String text, boolean somethingIs) {
  public static SimpleRecord of(
    final int number,
    final String text,
    final boolean somethingIs
  ) {
    return new SimpleRecord(number, text, somethingIs);
  }
}
