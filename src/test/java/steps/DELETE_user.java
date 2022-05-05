package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DELETE_user {

    RequestSpecification request;
    Response response;

    @When("I request delete users by id")
    public void iRequestDeleteUsersById() {
        request =
                given()
                        .contentType(ContentType.JSON);
        response = request
                    .when()
                    .delete("/users/71");
    }

    @Then("I validate the status delete user")
    public void iValidateTheStatusDeleteUser() {
        response.then()
                    .statusCode(204);

        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);
    }
}
