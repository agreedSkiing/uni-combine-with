package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.SimpleRecord;

class CombinedWithRecordTest {

  private static final Uni<Integer> NUMBER = Uni.createFrom().item(1);
  private static final Uni<String> TEXT = Uni.createFrom().item("texts");
  private static final Uni<Boolean> BOOLEAN = Uni.createFrom().item(true);
  private static final SimpleRecord EXPECTED = new SimpleRecord(
    1,
    "text",
    true
  );

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(SimpleRecord::new)
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
      .combinedWith(SimpleRecord::of)
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
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(this::constructor)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  private SimpleRecord constructor(
    int number,
    String text,
    boolean somethingIs
  ) {
    return new SimpleRecord(number, text, somethingIs);
  }
}
