package se.agreedskiing.uni.combined.with.tests.pojos;

public record SimpleRecord(int number, String text, boolean somethingIs) {
  public static SimpleRecord of(int number, String text, boolean somethingIs) {
    return new SimpleRecord(number, text, somethingIs);
  }
}
