package se.agreedskiing.uni.combined.with.examples.pojos;

public record ComplexRecord(
  int number,
  String text,
  boolean somethingIs,
  SimpleRecord simple,
  ListRecord list
) {
  public static ComplexRecord of(
    final int number,
    final String text,
    final boolean somethingIs,
    final SimpleRecord simple,
    final ListRecord list
  ) {
    return new ComplexRecord(number, text, somethingIs, simple, list);
  }
}
