package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.Objects;

public class SimpleClass {

  public static SimpleClass of(
    final int number,
    final String text,
    final boolean somethingIs
  ) {
    return new SimpleClass(number, text, somethingIs);
  }

  protected int number;
  protected String text;

  protected boolean somethingIs;

  public SimpleClass() {}

  public SimpleClass(
    final int number,
    final String text,
    final boolean somethingIs
  ) {
    this.number = number;
    this.text = text;
    this.somethingIs = somethingIs;
  }

  public int number() {
    return number;
  }

  public String text() {
    return text;
  }

  public boolean somethingIs() {
    return somethingIs;
  }

  public SimpleClass number(final int number) {
    this.number = number;
    return this;
  }

  public SimpleClass text(final String text) {
    this.text = text;
    return this;
  }

  public SimpleClass somethingIs(final boolean somethingIs) {
    this.somethingIs = somethingIs;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, text, somethingIs);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final SimpleClass other)) {
      return false;
    }
    return (
      number == other.number &&
      Objects.equals(text, other.text) &&
      somethingIs == other.somethingIs
    );
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("SimpleClass [number=");
    builder.append(number);
    builder.append(", ");
    if (text != null) {
      builder.append("text=");
      builder.append(text);
      builder.append(", ");
    }
    builder.append("somethingIs=");
    builder.append(somethingIs);
    builder.append("]");
    return builder.toString();
  }
}
