package tests;

import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;

public class DeletePet {
    @Test
    public void deletePet() {
        given()
                .spec(PetStoreSpecs.requestSpec())
                .body("{\"id\": 626, \"api_key\": \"special-key\" } ")
                .when()
                .post("")
                .then()
                .spec(PetStoreSpecs.successResponse());


    }
}
