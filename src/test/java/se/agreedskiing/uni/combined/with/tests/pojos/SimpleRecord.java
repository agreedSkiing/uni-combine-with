package se.agreedskiing.uni.combined.with.tests.pojos;

public record TestRecord(int number, String text, boolean somethingIs) {
  public static TestRecord of(int number, String text, boolean somethingIs) {
    return new TestRecord(number, text, somethingIs);
  }
}
