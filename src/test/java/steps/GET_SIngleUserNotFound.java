package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GET_SIngleUserNotFound {

    private RequestSpecification request;
    private Response response;

    @When("I request get single users not found")
    public void iRequestGetSingleUsersNotFound() {
        request = given().contentType(ContentType.JSON);
        response = request.get("/users/26");

    }

    @Then("I validate the status code single user not found")
    public void iValidateTheStatusCodeSingleUserNotFound() {
        response.then().statusCode(404);
        System.out.println("status code is : "+response.getStatusCode());
    }
}
