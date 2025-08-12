package tests;

import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPet {
    @Test
    public void addPet() {
        given()
                .spec(PetStoreSpecs.requestSpec())
                .body("{\"id\": 626, \"name\": \"StitchAuto\" } ")
                .when()
                .post("")
                .then()
                .spec(PetStoreSpecs.successResponse())
                .body("name", equalTo("StitchAuto"));
    }
}
