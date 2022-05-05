package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GET_listUsers {

    RequestSpecification request ;
    Response response;
    String url = "https://reqres.in/api";

    @Given("I set a base API request")
    public void iSetABaseAPIRequest() {
        RestAssured.baseURI = url;
    }

    @Given("I request get list users")
    public void iSetAPathForGetListUsers() {
        request = given().
                        contentType(ContentType.JSON);
        response = request.when().
                                get("/users?page=2");

    }

    @Then("I validate the status code list users")
    public void iValidateTheStatusCode() {
       response.then().
                    statusCode(200);

       int statusCode = response.getStatusCode();
        System.out.println("Status code is : " +statusCode);

    }

}
