package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GET_listUnknown {

    RequestSpecification request;
    Response response;

    @When("I request get list unknown")
    public void iRequestGetSingleUnknown() {
        request = given().
                        contentType(ContentType.JSON);
        response = request.when().
                                get("/unknown");
    }

    @Then("I validate the status code list unknown")
    public void iValidateTheStatusCodeListUnknown() {
        response.then().
                    statusCode(200);
        System.out.println("status code is : "+response.getStatusCode());
    }
}
