package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.TestListClass;

public class CombinedWithListClassTest {

  private static final Uni<List<Integer>> NUMBERS = Uni
    .createFrom()
    .item(List.of(1, 2));
  private static final Uni<List<String>> TEXTS = Uni
    .createFrom()
    .item(List.of("text1", "text2"));
  private static final Uni<List<Boolean>> BOOLEANS = Uni
    .createFrom()
    .item(List.of(true, false));
  private static final TestListClass EXPECTED = new TestListClass(
    List.of(1, 2),
    List.of("text1", "text2"),
    List.of(true, false)
  );

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBERS, TEXTS, BOOLEANS)
      .combinedWith(TestListClass::new)
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
      .unis(NUMBERS, TEXTS, BOOLEANS)
      .combinedWith(TestListClass::of)
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
        .unis(NUMBERS, TEXTS, BOOLEANS)
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
        .unis(NUMBERS, TEXTS, BOOLEANS)
        .combinedWith(this::setters)
        .subscribe()
        .withSubscriber(UniAssertSubscriber.create())
        .awaitItem()
        .assertItem(EXPECTED);
    }

    private TestListClass constructor(
      List<Integer> numbers,
      List<String> texts,
      List<Boolean> booleans
    ) {
      return new TestListClass(numbers, texts, booleans);
    }

    private TestListClass setters(
      List<Integer> numbers,
      List<String> texts,
      List<Boolean> booleans
    ) {
      return new TestListClass()
        .numbers(numbers)
        .texts(texts)
        .booleans(booleans);
    }
  }
}
