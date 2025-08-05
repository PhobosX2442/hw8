package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import specs.PetStoreSpecs;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PetApiTest {



    @Test
    public void testGetPet() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .when()
                .get("v2/pet/15")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess());
    }

    @Test
    public void testGetPet404() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .when()
                .get("v2/pet/999999")
                .then()
                .spec(PetStoreSpecs.responseSpecNotFound());
    }

    @Test
    public void addPet() {
        given()
                .spec(PetStoreSpecs.getRequestSpec())
                .body("{\"id\": 626, \"name\": \"StitchAuto\" } ")
                .when()
                .post("v2/pet")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess())
                .body("name", equalTo("StitchAuto"));

    }

    @Test //франкенштейн с выводом в консоль и добавлением полей через массив
    public void updPet() {
        Map<String, Object> pet = new HashMap<>();
        pet.put("id", 626);
        pet.put("name", "updStitchAuto");

        Response response = given()
                .spec(PetStoreSpecs.getRequestSpec())
                .body(pet)
                .when()
                .put("v2/pet");

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
                .post("v2/pet")
                .then()
                .spec(PetStoreSpecs.responseSpecSuccess());


    }

}
