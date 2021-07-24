package org.chedly;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@QuarkusTest
public class GreetingResourceTest {

    @RestClient
    @InjectMock
    remoteService service;


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hell/fr")
          .then()
             .statusCode(200)
             .body(is("testtesQuarkus !!! "));
    }

    @Test
    public void testRestEndpoint() {
        Mockito.when(service.getRemoteHello()).thenReturn("test");
        given()
          .when().get("/hell/break")
          .then()
             .statusCode(200)
             .body(is("test"));
    }
    @Test
    public void testndpoint() {
        Mockito.when(service.getRemoteHello()).thenReturn("test");
        given()
          .when().get("/hell")
          .then()
             .statusCode(200)
             .body(is("test"));
    }

}