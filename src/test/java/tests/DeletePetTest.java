package tests;

import dto.Pet;
import org.junit.jupiter.api.Test;
import data.PetFactory;
import data.PetStoreSpecs;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    Pet pet = PetFactory.getPet();


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
