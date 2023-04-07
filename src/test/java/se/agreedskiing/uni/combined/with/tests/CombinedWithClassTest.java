package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.TestClass;

public class CombinedWithClassTest {

  private static final Uni<Integer> NUMBER = Uni.createFrom().item(1);
  private static final Uni<String> TEXT = Uni.createFrom().item("text");
  private static final Uni<Boolean> BOOLEAN = Uni.createFrom().item(true);
  private static final TestClass EXPECTED = new TestClass(1, "text", true);

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(TestClass::new)
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
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(TestClass::of)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  @Nested
  class method_ {

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

    private TestClass constructor(
      int number,
      String text,
      boolean somethingIs
    ) {
      return new TestClass(number, text, somethingIs);
    }

    private TestClass setters(int number, String text, boolean somethingIs) {
      return new TestClass().number(number).text(text).somethingIs(somethingIs);
    }
  }
}
