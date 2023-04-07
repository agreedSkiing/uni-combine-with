package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.Objects;

public class SimpleClass {

  private int number;
  private String text;
  private boolean somethingIs;

  public SimpleClass() {}

  public SimpleClass(int number, String text, boolean somethingIs) {
    this.number = number;
    this.text = text;
    this.somethingIs = somethingIs;
  }

  public static SimpleClass of(int number, String text, boolean somethingIs) {
    return new SimpleClass(number, text, somethingIs);
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

  public SimpleClass number(int number) {
    this.number = number;
    return this;
  }

  public SimpleClass text(String text) {
    this.text = text;
    return this;
  }

  public SimpleClass somethingIs(boolean somethingIs) {
    this.somethingIs = somethingIs;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, text, somethingIs);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SimpleClass other)) {
      return false;
    }
    return (
      number == other.number &&
      Objects.equals(text, other.text) &&
      somethingIs == other.somethingIs
    );
  }
}
