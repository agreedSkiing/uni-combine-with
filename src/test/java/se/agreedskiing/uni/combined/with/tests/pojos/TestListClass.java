package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.List;
import java.util.Objects;

public class TestListClass {

  private List<Integer> numbers;
  private List<String> texts;
  private List<Boolean> booleans;

  public TestListClass() {}

  public TestListClass(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    this.numbers = numbers;
    this.texts = texts;
    this.booleans = booleans;
  }

  public static TestListClass of(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    return new TestListClass(numbers, texts, booleans);
  }

  public List<Integer> numbers() {
    return numbers;
  }

  public List<String> texts() {
    return texts;
  }

  public List<Boolean> booleans() {
    return booleans;
  }

  public TestListClass numbers(List<Integer> numbers) {
    this.numbers = numbers;
    return this;
  }

  public TestListClass texts(List<String> texts) {
    this.texts = texts;
    return this;
  }

  public TestListClass booleans(List<Boolean> booleans) {
    this.booleans = booleans;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers, texts, booleans);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof TestListClass other)) {
      return false;
    }
    return (
      Objects.equals(numbers, other.numbers) &&
      Objects.equals(texts, other.texts) &&
      Objects.equals(booleans, other.booleans)
    );
  }
}
