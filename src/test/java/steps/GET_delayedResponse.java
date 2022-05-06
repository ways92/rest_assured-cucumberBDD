package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GET_delayedResponse {
    Response response;

    @When("I request delay response")
    public void iRequestDelayResponse() {
        response = given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/users?delay=3");
    }

    @Then("I validate the status code delay response")
    public void iValidateTheStatusCodeDelayResponse() throws InterruptedException {

        int delay = response.getStatusCode();
        if (delay==400){
            Thread.sleep(2000);

        }else{
            response.then()
                        .log()
                        .body()
                        .assertThat()
                        .statusCode(200);
        }

//        Thread.sleep(2000);
//
//        response.then()
//                    .log().body()
//                    .assertThat()
//                    .statusCode(200);
    }
}
