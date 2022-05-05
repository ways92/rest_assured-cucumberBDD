package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PUT_user {

    RequestSpecification request;
    Response response;
    String namePut = "Ways";
    String jobPut = "Marketing";

    @When("I request put user")
    public void iRequestPutUser() {
        JSONObject req = new JSONObject();
        req.put("name", namePut);
        req.put("job", jobPut);

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
                    .body(
                            "name", equalTo(namePut),
                            "job", equalTo(jobPut)
                    )

                    .log().body()
                    .log().status();

        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+statusCode);
    }
}
