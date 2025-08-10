package tests;

import dto.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PetApiTest {



    @Test
    public void testGetPet() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .when()
                .get("1")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess());
    }

    @Test
    public void testGetPet404() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .when()
                .get("/999999")
                .then()
                .spec(PetStoreSpecs.responseSpecNotFound());
    }

    @Test
    public void addPet() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .body("{\"id\": 626, \"name\": \"StitchAuto\" } ")
                .when()
                .post("")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess())
                .body("name", equalTo("StitchAuto"));

    }

    @Test //франкенштейн с выводом в консоль и добавлением полей через массив
    public void updPet() {

        Pet pet = Pet.builder()
                .id(626)
                .name("updStitchAuto")
                .build();

        Response response = given()
                .spec(PetStoreSpecs.getRequestSpec())
                .body(pet)
                .when()
                .put("");

                response.then()
                .spec(PetStoreSpecs.responseSpecSuccess())
                .body("name", equalTo("updStitchAuto"));

        System.out.println("Метод: updTest");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("id: " + response.jsonPath().getInt("id") + " | name: " + response.jsonPath().getString("name"));
    }

    @Test
    public void delPet() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .body("{\"id\": 626, \"api_key\": \"special-key\" } ")
                .when()
                .post("")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess());


    }

}
