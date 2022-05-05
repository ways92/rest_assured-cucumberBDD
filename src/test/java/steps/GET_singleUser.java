package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GET_singleUser {

    RequestSpecification request;
    Response response;

    @Given("I request get single users")
    public void iRequestGetSingleUsers() {
        request = given()
                        .contentType(ContentType.JSON);

        response = request
                    .when()
                        .get("/users/2");

    }

    @Then("I validate the status code single user")
    public void iValidateTheStatusCodeSingleUser() {
        response.then()
                    .statusCode(200);
        System.out.println("status code is : "+response.getStatusCode());
    }

}
