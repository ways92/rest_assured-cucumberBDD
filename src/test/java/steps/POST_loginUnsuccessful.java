package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class POST_loginUnsuccessful {
    Response response;
    String emailLogin = "emailsalah@gmail.com";

    @When("I request post login unsuccessful")
    public void iRequestPostLoginUnsuccessful() {
        JSONObject req = new JSONObject();
        req.put("email",emailLogin);

        response = given()
                    .contentType(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                .post("/login");
    }

    @Then("I validate the status code post login unsuccessful")
    public void iValidateTheStatusCodePostLoginUnsuccessful() throws InterruptedException {
        response.then()
                    .log().body()
                    .assertThat()
                    .statusCode(400);
    }
}
