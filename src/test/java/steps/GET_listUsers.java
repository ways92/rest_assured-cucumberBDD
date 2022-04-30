package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GET_listUsers {

    private RequestSpecification request ;
    private Response response;
    String url = "https://reqres.in/api";

    @Given("I set a base API request")
    public void iSetABaseAPIRequest() {
        RestAssured.baseURI = url;
        RestAssured.basePath = "/users?page=2";
    }

    @Given("I set a path for get list users")
    public void iSetAPathForGetListUsers() {
        request = given().contentType(ContentType.JSON);
        response = request.when().get();

    }

    @Then("I validate the status code")
    public void iValidateTheStatusCode() {
       response.then().statusCode(200).log().all();
        System.out.println(response.getStatusCode());

    }

}
