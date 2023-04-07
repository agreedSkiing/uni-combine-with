package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.Objects;

public class TestClass {

  private int number;
  private String text;
  private boolean somethingIs;

  public TestClass() {}

  public TestClass(int number, String text, boolean somethingIs) {
    this.number = number;
    this.text = text;
    this.somethingIs = somethingIs;
  }

  public static TestClass of(int number, String text, boolean somethingIs) {
    return new TestClass(number, text, somethingIs);
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

  public TestClass number(int number) {
    this.number = number;
    return this;
  }

  public TestClass text(String text) {
    this.text = text;
    return this;
  }

  public TestClass somethingIs(boolean somethingIs) {
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
    if (!(obj instanceof TestClass other)) {
      return false;
    }
    return (
      number == other.number &&
      Objects.equals(text, other.text) &&
      somethingIs == other.somethingIs
    );
  }
}
