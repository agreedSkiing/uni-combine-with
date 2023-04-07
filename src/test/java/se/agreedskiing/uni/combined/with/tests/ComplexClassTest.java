package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.*;

public class ComplexClassTest {

  //-------------------- Normal statics
  private static final Integer NUMBER = 1;
  private static final String TEXT = "text";
  private static final Boolean BOOLEAN = true;
  private static final SimpleClass SIMPLE_Class = new SimpleClass(
    NUMBER,
    TEXT,
    BOOLEAN
  );
  private static final ListClass LIST_Class = new ListClass(
    List.of(NUMBER, 2),
    List.of(TEXT, "text2"),
    List.of(BOOLEAN, false)
  );

  //-------------------- Create unis!
  private static final Uni<Integer> UNI_NUMBER = Uni.createFrom().item(NUMBER);
  private static final Uni<String> UNI_TEXT = Uni.createFrom().item(TEXT);
  private static final Uni<Boolean> UNI_BOOLEAN = Uni
    .createFrom()
    .item(BOOLEAN);
  private static final Uni<SimpleClass> UNI_SIMPLE_CLASS = Uni
    .createFrom()
    .item(SIMPLE_Class);
  private static final Uni<ListClass> UNI_LIST_CLASS = Uni
    .createFrom()
    .item(LIST_Class);

  //-------------------- EXPECTED
  private static final ComplexClass EXPECTED = new ComplexClass(
    NUMBER,
    TEXT,
    BOOLEAN,
    SIMPLE_Class,
    LIST_Class
  );

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(UNI_NUMBER, UNI_TEXT, UNI_BOOLEAN, UNI_SIMPLE_CLASS, UNI_LIST_CLASS)
      .combinedWith(ComplexClass::new)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  @Test
  void static_constructor() {
    Uni
      .combine()
      .all()
      .unis(UNI_NUMBER, UNI_TEXT, UNI_BOOLEAN, UNI_SIMPLE_CLASS, UNI_LIST_CLASS)
      .combinedWith(ComplexClass::of)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED)
      .assertCompleted();
  }

  @Nested
  class method_ {

    @Test
    void using_constructor() {
      Uni
        .combine()
        .all()
        .unis(
          UNI_NUMBER,
          UNI_TEXT,
          UNI_BOOLEAN,
          UNI_SIMPLE_CLASS,
          UNI_LIST_CLASS
        )
        .combinedWith(this::constructor)
        .subscribe()
        .withSubscriber(UniAssertSubscriber.create())
        .awaitItem()
        .assertItem(EXPECTED);
    }

    @Test
    void using_setter() {
      Uni
        .combine()
        .all()
        .unis(
          UNI_NUMBER,
          UNI_TEXT,
          UNI_BOOLEAN,
          UNI_SIMPLE_CLASS,
          UNI_LIST_CLASS
        )
        .combinedWith(this::setters)
        .subscribe()
        .withSubscriber(UniAssertSubscriber.create())
        .awaitItem()
        .assertItem(EXPECTED);
    }

    private ComplexClass constructor(
      final int number,
      final String text,
      final boolean somethingIs,
      final SimpleClass simple,
      final ListClass list
    ) {
      return new ComplexClass(number, text, somethingIs, simple, list);
    }

    private ComplexClass setters(
      final int number,
      final String text,
      final boolean somethingIs,
      final SimpleClass simple,
      final ListClass list
    ) {
      return new ComplexClass()
        .simple(simple)
        .list(list)
        .number(number)
        .text(text)
        .somethingIs(somethingIs);
    }
  }
}
