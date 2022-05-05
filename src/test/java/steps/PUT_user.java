package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PUT_user {

    RequestSpecification request;
    Response response;

    @When("I request put user")
    public void iRequestPutUser() {
        JSONObject req = new JSONObject();
        req.put("name", "Ways");
        req.put("job", "Marketing");

        request =
                given()
                        .contentType(ContentType.JSON)
                        .body(req.toJSONString());
        response = request
                .when()
                    .put("/users/9");
    }

    @Then("I validate the status code put user")
    public void iValidateTheStatusCodePutUser() {
        response.then()
                    .statusCode(200)
                    .log().all();

        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);
    }
}
