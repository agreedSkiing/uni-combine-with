package se.agreedskiing.uni.combined.with.examples;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.examples.pojos.ClassWithLists;

public class ClassWithListsTest {

  private static final Uni<List<Integer>> NUMBERS = Uni
    .createFrom()
    .item(List.of(1, 2));
  private static final Uni<List<String>> TEXTS = Uni
    .createFrom()
    .item(List.of("text1", "text2"));
  private static final Uni<List<Boolean>> BOOLEANS = Uni
    .createFrom()
    .item(List.of(true, false));
  private static final ClassWithLists EXPECTED = new ClassWithLists(
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
      .combinedWith(ClassWithLists::new)
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
      .combinedWith(ClassWithLists::of)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED)
      .assertCompleted();
  }

  @Nested
  class method {

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

    private ClassWithLists constructor(
      List<Integer> numbers,
      List<String> texts,
      List<Boolean> booleans
    ) {
      return new ClassWithLists(numbers, texts, booleans);
    }

    private ClassWithLists setters(
      List<Integer> numbers,
      List<String> texts,
      List<Boolean> booleans
    ) {
      return new ClassWithLists()
        .numbers(numbers)
        .texts(texts)
        .booleans(booleans);
    }
  }
}
