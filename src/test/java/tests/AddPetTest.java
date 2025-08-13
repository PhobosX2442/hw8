package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import specs.PetFactory;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPetTest {
    @Test
    public void addPet() {

        Pet.PetBuilder builder = PetFactory.getPet();
        Pet pet = builder.build();

        given()
                .spec(PetStoreSpecs.requestSpec())
                .body(pet)
                .when()
                .post("")
                .then()
                .spec(PetStoreSpecs.successResponse())
                .body("name", equalTo("StitchAuto"));
    }
}
