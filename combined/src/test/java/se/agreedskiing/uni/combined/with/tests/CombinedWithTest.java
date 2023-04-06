package se.agreedskiing.uni.combined.with.tests;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CombinedWithTest {

    @Nested
    class using_record_ {

        @Test
        void constructor() {
            given()
                    .when().get("/hello")
                    .then()
                    .statusCode(200)
                    .body(is("Hello RESTEasy"));
                }
                @Test
                void methods() {
                    given()
                            .when().get("/hello")
                            .then()
                            .statusCode(200)
                            .body(is("Hello RESTEasy"));
                }
    }
    
    @Test
    public void using_object_constructor() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}