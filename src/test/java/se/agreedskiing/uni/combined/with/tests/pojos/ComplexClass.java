package se.agreedskiing.uni.combined.with.tests.pojos;

import java.util.Objects;

public class ComplexClass extends SimpleClass {

  public static ComplexClass of(
    final int number,
    final String text,
    final boolean somethingIs,
    final SimpleClass simple,
    final ListClass list
  ) {
    return new ComplexClass(number, text, somethingIs, simple, list);
  }

  private SimpleClass simple;
  private ListClass list;

  public ComplexClass() {}

  public ComplexClass(
    final int number,
    final String text,
    final boolean somethingIs,
    final SimpleClass simple,
    final ListClass list
  ) {
    super(number, text, somethingIs);
    this.simple = simple;
    this.list = list;
  }

  public SimpleClass simple() {
    return simple;
  }

  public ListClass list() {
    return list;
  }

  public ComplexClass simple(final SimpleClass simple) {
    this.simple = simple;
    return this;
  }

  public ComplexClass list(final ListClass list) {
    this.list = list;
    return this;
  }

  @Override
  public ComplexClass number(final int number) {
    this.number = number;
    return this;
  }

  @Override
  public ComplexClass text(final String text) {
    this.text = text;
    return this;
  }

  @Override
  public ComplexClass somethingIs(final boolean somethingIs) {
    this.somethingIs = somethingIs;
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(simple, list);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (!(obj instanceof ComplexClass other)) {
      return false;
    }
    return (
      Objects.equals(simple, other.simple) && Objects.equals(list, other.list)
    );
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ComplexClass [");
    if (simple != null) {
      builder.append("simple=");
      builder.append(simple);
      builder.append(", ");
    }
    if (list != null) {
      builder.append("list=");
      builder.append(list);
    }
    builder.append("]");
    return builder.toString();
  }
}
