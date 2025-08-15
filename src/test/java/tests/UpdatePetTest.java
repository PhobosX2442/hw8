package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import data.PetFactory;
import data.PetStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePetTest {
    @Test
    public void updatePet() {

        Pet pet = PetFactory.getSecondPet();

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
