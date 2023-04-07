package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.ListRecord;

class ListRecordTest {

  private static final Uni<List<Integer>> NUMBERS = Uni
    .createFrom()
    .item(List.of(1, 2));
  private static final Uni<List<String>> TEXTS = Uni
    .createFrom()
    .item(List.of("text1", "text2"));
  private static final Uni<List<Boolean>> BOOLEANS = Uni
    .createFrom()
    .item(List.of(true, false));
  private static final ListRecord EXPECTED = new ListRecord(
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
      .combinedWith(ListRecord::new)
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
      .combinedWith(ListRecord::of)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  @Test
  void method_using_constructor() {
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

  private ListRecord constructor(
    List<Integer> numbers,
    List<String> texts,
    List<Boolean> booleans
  ) {
    return new ListRecord(numbers, texts, booleans);
  }
}
