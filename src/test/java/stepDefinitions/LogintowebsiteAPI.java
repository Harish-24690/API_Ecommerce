package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import pojo.LoginResponse;
import resources.ResourcesAPI;
import resources.TestDataBuild;
import resources.Utils;

public class LogintowebsiteAPI extends Utils {

	//TestDataBuild testDataBuild;
	TestDataBuild testDataBuild = new TestDataBuild();
	RequestSpecification res;
	static LoginResponse loginresponse;

	@Given("LogintoWebsite Payload")
	public void loginto_website_payload() throws IOException {

		

		 
		res = given().header("Content-Type", "application/json").log().all().spec(requestSpecification()).body(testDataBuild.logintoWebsite());

		/*
		 * UserDetails userDetails = new UserDetails();
		 * userDetails.setUserEmail("testautomation0691@gmail.com");
		 * userDetails.setUserPassword("Test@0691");
		 */
		/*
		 * RequestSpecification requestSpecification = new RequestSpecBuilder()
		 * .setBaseUri("https://rahulshettyacademy.com").addHeader("Content-Type",
		 * "application/json").build();
		 */
	}

	@When("User calls the {string} API with {string} http Request")
	public void user_calls_the_api_with_http_request(String resource, String httpsmethod) {

		ResourcesAPI resourceAPI = ResourcesAPI.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (httpsmethod.equalsIgnoreCase("POST")) {
			loginresponse = res.when().log().all().post(resourceAPI.getResource()).then().log().all().assertThat()
					.extract().response().as(LoginResponse.class);}
		else if (httpsmethod.equalsIgnoreCase("GET")) {
			loginresponse = res.when().log().all().get(resourceAPI.getResource()).then().log().all().assertThat()
					.extract().response().as(LoginResponse.class);}
		else if (httpsmethod.equalsIgnoreCase("Delete")) {
			loginresponse = res.when().log().all().delete(resourceAPI.getResource()).then().log().all().assertThat()
			.extract().response().as(LoginResponse.class);}

		/*
		 * loginresponse=loginreq.when().log().all().post("/api/ecom/auth/login")
		 * .then().log().all().assertThat().statusCode(200).extract().response().as(
		 * LoginResponse.class);
		 */
	}

	@Then("The API call got success and verify if the status code is {int}")
	public void the_api_call_got_success_and_verify_if_the_status_code_is(Integer status) {
		

	}

	@And("Verify the {string} at responsebody is {string}")
	public void verify_the_at_responsebody_is(String keyValue, String expected) {

		String message = loginresponse.getMessage();
		Assert.assertEquals(expected, message);

	}
	@Given("^CreateProduct Payload$")
    public void createproduct_payload() throws Throwable {
		 res=given().spec(requestSpecification())
				.header("Authorization", loginresponse.getToken()).param("productName", "laptop") .param("productAddedBy", loginresponse.getUserId())
						.param("productCategory","fashion").param("productSubCategory", "shirts")
						.param("productPrice","11500").param("productDescription", "Dell").param("productFor","All")
						.multiPart("productImage",new File("C:\\Users\\HARISH R\\Desktop\\image.jpg"));
				
				
        
    }
	
	@Given("^CreateOrder Payload$")
    public void createorder_payload() throws Throwable {
		System.out.println(loginresponse.getToken());
		System.out.println(loginresponse.getProductId());
      res=  given().log().all().spec(requestSpecification()).header("Authorization",loginresponse.getToken()).header("Content-Type", "application/json")
    		  .body(testDataBuild.createOrderPayload(loginresponse.getProductId()));
    }
	
	@Given("^OrderId for getting Orderdetails$")
    public void orderid_for_getting_orderdetails() throws Throwable {
       res=given().spec(requestSpecification()).header("Authorization", loginresponse.getToken()).queryParam("id", loginresponse.getOrders().get(0));
    }
	
	@Given("^Delete an order by passing ProductId$")
    public void delete_an_order_by_passing_productid() throws Throwable {
        res=given().spec(requestSpecification()).header("Authorization",loginresponse.getToken()).pathParam("id",loginresponse.getProductId());
    }
}
