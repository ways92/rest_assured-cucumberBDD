package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POST_User {

    RequestSpecification request;
    Response response;
    String namePost = "Ways AL";
    String jobPost = "Tukang";

    @When("I request post user")
    public void iRequestPostUser() {

        JSONObject req = new JSONObject();
        req.put("name", namePost);
        req.put("job", jobPost);

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
                .body("name", equalTo(namePost))
                .body("job", equalTo(jobPost))
                .log().body()
                .log().status();

        System.out.println("status code is : "+response.getStatusCode());
    }
}
