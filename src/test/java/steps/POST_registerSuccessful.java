package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class POST_registerSuccessful {

    RequestSpecification request;
    Response response;
    String emailReg = "eve.holt@reqres.in";
    String passReg = "pistol";

    @When("I request post register successful")
    public void iRequestPostRegisterSuccessful() {
        JSONObject req = new JSONObject();
        req.put("email",emailReg );
        req.put("password",passReg );

        request =
                given()
                        .header("Content-Type","application/json")
                        .body(req.toJSONString());

        response = request
                .when()
                    .post("/register");
    }

    @Then("I validate the status code post register successful")
    public void iValidateTheStatusCodePostRegisterSuccessful() {
        response.then()
                    .log().body()
                    .assertThat()
                    .statusCode(200);

        String getToken = response.jsonPath().getString("token");

        System.out.println(getToken);

        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);
    }
}
