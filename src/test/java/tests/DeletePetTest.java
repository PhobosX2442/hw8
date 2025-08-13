package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import specs.PetFactory;
import specs.PetStoreSpecs;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    Pet.PetBuilder builder = PetFactory.getPet();
    Pet pet = builder.build();


    @Test
    public void deletePet() {
        given()
                .spec(PetStoreSpecs.requestSpec())
                .body(pet)
                .when()
                .delete("626")
                .then()
                .spec(PetStoreSpecs.successResponse());


    }
}
