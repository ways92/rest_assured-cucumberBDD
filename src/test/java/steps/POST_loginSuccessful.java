package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class POST_loginSuccessful {

    Response response;
    String emailLogin = "eve.holt@reqres.in";
    String passLogin = "pistol";

    @When("I request post login successful")
    public void iRequestPostLoginSuccessful() {

        JSONObject req = new JSONObject();
        req.put("email", emailLogin);
        req.put("password", passLogin);

        response = given()
                    .contentType(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                    .post("/login");


    }

    @Then("I validate the status code post login successful")
    public void iValidateTheStatusCodePostLoginSuccessful() {
        response.then()
                    .log().body()
                    .statusCode(200);

        String getToken = response.jsonPath().getString("token");
        System.out.println("your token is --> "+getToken);
    }
}
