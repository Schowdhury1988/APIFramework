package stepDefinations;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resourses.APIResourses;
import resourses.Utils;
import resourses.testDataBuild;


import java.io.FileNotFoundException;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class stepDefinatons extends Utils {

    testDataBuild data = new testDataBuild();


    ResponseSpecification resspec;
    RequestSpecification   res;
    Response response;
  static   String place_id;

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_Place_Payload_with(String name, String phone_number, String address) throws IOException {

        res = given().log().all().spec(requestSpecification())
                .body(data.addPlacePayload(name, phone_number, address));
    }

    @When("User calls {string} API'S by {string} http request")
    public void user_calls_API_S_by_http_request(String resourse, String method) {

        // Write code here that turns the phrase above into concrete actions


      APIResourses resourseAPI=   APIResourses.valueOf(resourse);
        System.out.println(resourseAPI.getResourse());
        resspec = new ResponseSpecBuilder().expectStatusCode(200).build();
        if(method.equalsIgnoreCase("POST"))
         response =  res.when().post(resourseAPI.getResourse());
        else if(method.equalsIgnoreCase("GET"))
            response =  res.when().get(resourseAPI.getResourse());
//                        then().spec(resspec).extract().response();
//        String ResponseString = response.asString();
//        System.out.println(ResponseString);
    }
    @Then("the API call got sucess with status code {int}")
    public void the_API_call_got_sucess_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }
    @And("{string} in response body is {string}")
    public void in_response_body_is(String keyvalue, String expectedvalue) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(getJSonPath(response,keyvalue),expectedvalue);
    }
    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
        // Write code here that turns the phrase above into concrete actions

       place_id = getJSonPath(response,"place_id");
        res = given().log().all().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_API_S_by_http_request(resourse,"get");

        String actualName= getJSonPath(response,"name");
              assertEquals(actualName,expectedName);
    }
    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
      res=  given().log().all().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }

}
