package se.agreedskiing.uni.combined.with.tests;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.tests.pojos.TestRecord;

class CombinedWithRecordTest {

  private static final Uni<Integer> NUMBER = Uni.createFrom().item(1);
  private static final Uni<String> TEXT = Uni.createFrom().item("text");
  private static final Uni<Boolean> BOOLEAN = Uni.createFrom().item(true);
  private static final TestRecord EXPECTED = new TestRecord(1, "text", true);

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(NUMBER, TEXT, BOOLEAN)
      .combinedWith(TestRecord::new)
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
      .combinedWith(TestRecord::of)
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

  private TestRecord constructor(int number, String text, boolean somethingIs) {
    return new TestRecord(number, text, somethingIs);
  }
}
