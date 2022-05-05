package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_singleUnknown {

    RequestSpecification request;
    Response response;

    @When("I request get single unknown")
    public void iRequestGetSingleUnknown() {
        request = given()
                        .contentType(ContentType.JSON);

        response = request
                .when()
                    .get("/unknown/2");
    }

    @Then("I validate the status code single unknown")
    public void iValidateTheStatusCodeSingleUnknown() {
        response.then()
                    .statusCode(200)
                    .body("data.name", equalTo("fuchsia rose"))
                    .log().all();

        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);
    }
}
