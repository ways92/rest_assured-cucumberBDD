package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class POST_registerUnsuccessful {

    Response response;
    String emailPost = "waysInvalid@gmail.com";

    @When("I request post register unsuccessful")
    public void iRequestPostRegisterUnsuccessful() {
        JSONObject req = new JSONObject();
        req.put("email", emailPost);

        response = given()
                    .contentType(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                    .post("/register");

    }

    @Then("I validate the status code post register unsuccessful")
    public void iValidateTheStatusCodePostRegisterUnsuccessful() {
        response.then()
                    .log().body()
                    .statusCode(400);
    }
}
