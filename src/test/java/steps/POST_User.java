package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class POST_User {

    RequestSpecification request;
    Response response;

    @When("I request post user")
    public void iRequestPostUser() {

        JSONObject req = new JSONObject();
        req.put("name", "Ways AL");
        req.put("job", "Tukang");

        request =
                given()
                        .contentType(ContentType.JSON)
                        .body(req.toJSONString());

        response = request
                .when()
                    .post("/users");
    }

    @Then("I validate the status code post user")
    public void iValidateTheStatusCodePostUser() {
        response.then()
                .statusCode(201)
                .log().all();
        System.out.println("status code is : "+response.getStatusCode());
    }
}
