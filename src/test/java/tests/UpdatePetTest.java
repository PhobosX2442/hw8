package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import specs.PetFactory;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePetTest {
    @Test
    public void updatePet() {

        Pet.PetBuilder builder = PetFactory.getSecondPet();
        Pet pet = builder.build();


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
