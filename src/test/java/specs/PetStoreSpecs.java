package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PetStoreSpecs {


    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    public static ResponseSpecification responseSpecSuccess() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpecNotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType("application/json")
                .build();
    }

}
