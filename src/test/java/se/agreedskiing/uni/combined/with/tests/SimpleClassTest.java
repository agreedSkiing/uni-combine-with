package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.SimpleClass;

public class SimpleClassTest {

  private static final Uni<Integer> NUMBER = Uni.createFrom().item(1);
  private static final Uni<String> TEXT = Uni.createFrom().item("text");
  private static final Uni<Boolean> BOOLEAN = Uni.createFrom().item(true);
  private static final SimpleClass EXPECTED = new SimpleClass(1, "text", true);

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(SimpleClass::new)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
    System.out.println("HELLO");
  }

  @Test
  void static_constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(SimpleClass::of)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  @Nested
  class method {

    @Test
    void using_constructor() {
      Uni
        .combine()
        .all()
        .unis(NUMBER, TEXT, BOOLEAN)
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
        .unis(NUMBER, TEXT, BOOLEAN)
        .combinedWith(this::setters)
        .subscribe()
        .withSubscriber(UniAssertSubscriber.create())
        .awaitItem()
        .assertItem(EXPECTED);
    }

    private SimpleClass constructor(
      int number,
      String text,
      boolean somethingIs
    ) {
      return new SimpleClass(number, text, somethingIs);
    }

    private SimpleClass setters(int number, String text, boolean somethingIs) {
      return new SimpleClass()
        .number(number)
        .text(text)
        .somethingIs(somethingIs);
    }
  }
}
