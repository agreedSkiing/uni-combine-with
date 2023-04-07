package se.agreedskiing.uni.combined.with.examples;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.agreedskiing.uni.combined.with.examples.pojos.*;

class ComplexRecordTest {

  //-------------------- Normal statics
  private static final Integer NUMBER = 1;
  private static final String TEXT = "text";
  private static final Boolean BOOLEAN = true;
  private static final SimpleRecord SIMPLE_RECORD = new SimpleRecord(
    NUMBER,
    TEXT,
    BOOLEAN
  );
  private static final ListRecord LIST_RECORD = new ListRecord(
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
  private static final Uni<SimpleRecord> UNI_SIMPLE_RECORD = Uni
    .createFrom()
    .item(SIMPLE_RECORD);
  private static final Uni<ListRecord> UNI_LIST_RECORD = Uni
    .createFrom()
    .item(LIST_RECORD);

  //-------------------- EXPECTED
  private static final ComplexRecord EXPECTED = new ComplexRecord(
    NUMBER,
    TEXT,
    BOOLEAN,
    SIMPLE_RECORD,
    LIST_RECORD
  );

  @Test
  void constructor() {
    Uni
      .combine()
      .all()
      .unis(
        UNI_NUMBER,
        UNI_TEXT,
        UNI_BOOLEAN,
        UNI_SIMPLE_RECORD,
        UNI_LIST_RECORD
      )
      .combinedWith(ComplexRecord::new)
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
      .unis(
        UNI_NUMBER,
        UNI_TEXT,
        UNI_BOOLEAN,
        UNI_SIMPLE_RECORD,
        UNI_LIST_RECORD
      )
      .combinedWith(ComplexRecord::of)
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
      .unis(
        UNI_NUMBER,
        UNI_TEXT,
        UNI_BOOLEAN,
        UNI_SIMPLE_RECORD,
        UNI_LIST_RECORD
      )
      .combinedWith(this::constructor)
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertItem(EXPECTED);
  }

  private ComplexRecord constructor(
    final int number,
    final String text,
    final boolean somethingIs,
    final SimpleRecord simple,
    final ListRecord list
  ) {
    return new ComplexRecord(number, text, somethingIs, simple, list);
  }
}
