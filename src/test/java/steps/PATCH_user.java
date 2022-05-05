package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PATCH_user {

    RequestSpecification request;
    Response response;
    String jobPatch = "Sales";

    @When("I request patch user")
    public void iRequestPatchUser() {
        JSONObject req = new JSONObject();

        req.put("job", jobPatch);

        request = given()
                        .contentType(ContentType.JSON)
                        .body(req.toJSONString());

        response = request
                .when()
                    .patch("/users/9");
    }

    @Then("I validate the status code patch user")
    public void iValidateTheStatusCodePatchUser() {

        response.then()
                .statusCode(200)
                .log().all()
                .body("job",equalTo(jobPatch));
        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);

    }
}
