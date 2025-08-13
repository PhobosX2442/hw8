package tests;

import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;

public class GetPetTest {

    @Test
    public void testGetPet() {
        given()
                .spec(PetStoreSpecs.requestSpec())
                .when()
                .get("/1")
                .then()
                .spec(PetStoreSpecs.successResponse());
    }

    @Test
    public void testGetPet404() {
        given()
                .spec(PetStoreSpecs.requestSpec())
                .when()
                .get("/999999")
                .then()
                .spec(PetStoreSpecs.notFoundResponse());
    }
}
