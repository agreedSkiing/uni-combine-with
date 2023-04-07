package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.List;
import java.util.Objects;

public class ListClass {

  private List<Integer> numbers;
  private List<String> texts;
  private List<Boolean> booleans;

  public ListClass() {}

  public ListClass(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    this.numbers = numbers;
    this.texts = texts;
    this.booleans = booleans;
  }

  public static ListClass of(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    return new ListClass(numbers, texts, booleans);
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

  public ListClass numbers(List<Integer> numbers) {
    this.numbers = numbers;
    return this;
  }

  public ListClass texts(List<String> texts) {
    this.texts = texts;
    return this;
  }

  public ListClass booleans(List<Boolean> booleans) {
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
    if (!(obj instanceof ListClass other)) {
      return false;
    }
    return (
      Objects.equals(numbers, other.numbers) &&
      Objects.equals(texts, other.texts) &&
      Objects.equals(booleans, other.booleans)
    );
  }
}
