package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.List;
import java.util.Objects;

public class ListClass {

  public static ListClass of(
    final List<Integer> numbers,
    final List<String> texts,
    final List<Boolean> booleans
  ) {
    return new ListClass(numbers, texts, booleans);
  }

  private List<Integer> numbers;
  private List<String> texts;

  private List<Boolean> booleans;

  public ListClass() {}

  public ListClass(
    final List<Integer> numbers,
    final List<String> texts,
    final List<Boolean> booleans
  ) {
    this.numbers = numbers;
    this.texts = texts;
    this.booleans = booleans;
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

  public ListClass numbers(final List<Integer> numbers) {
    this.numbers = numbers;
    return this;
  }

  public ListClass texts(final List<String> texts) {
    this.texts = texts;
    return this;
  }

  public ListClass booleans(final List<Boolean> booleans) {
    this.booleans = booleans;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers, texts, booleans);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final ListClass other)) {
      return false;
    }
    return (
      Objects.equals(numbers, other.numbers) &&
      Objects.equals(texts, other.texts) &&
      Objects.equals(booleans, other.booleans)
    );
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("ListClass [");
    if (numbers != null) {
      builder.append("numbers=");
      builder.append(numbers);
      builder.append(", ");
    }
    if (texts != null) {
      builder.append("texts=");
      builder.append(texts);
      builder.append(", ");
    }
    if (booleans != null) {
      builder.append("booleans=");
      builder.append(booleans);
    }
    builder.append("]");
    return builder.toString();
  }
}
