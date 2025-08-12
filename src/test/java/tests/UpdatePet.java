package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePet {
    @Test
    public void updatePet() {

        Pet pet = Pet.builder()
                .id(626)
                .name("updStitchAuto")
                .build();

        given()
                .spec(PetStoreSpecs.requestSpec())
                .body(pet)
                .when()
                .put("")
                .then()
                .spec(PetStoreSpecs.successResponse())
                .body("name", equalTo("updStitchAuto"));
    }
}
