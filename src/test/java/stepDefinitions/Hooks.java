package stepDefinitions;

import io.cucumber.java.Before;
import pojo.LoginResponse;

public class Hooks {
	LogintowebsiteAPI login= new LogintowebsiteAPI();
	
	@Before("@CreateProduct")
	public void beforeScenario() throws Throwable {
		if(LoginResponse.token==null) {
		
		
		login.loginto_website_payload();
		login.user_calls_the_api_with_http_request("LogintoWebsite", "POST");
		}
		
	}
	@Before("@CreateOrder")
	public void beforeCreateOrder() throws Throwable {
		
		login.loginto_website_payload();
		login.user_calls_the_api_with_http_request("LogintoWebsite", "POST");
		login.createproduct_payload();
		login.user_calls_the_api_with_http_request("CreateProductAPI", "POST");
		
		
	}
	@Before("@getOrderDetails or @DeleteOrder")
	public void before() throws Throwable {
		login.loginto_website_payload();
		login.user_calls_the_api_with_http_request("LogintoWebsite", "POST");
		login.createproduct_payload();
		login.user_calls_the_api_with_http_request("CreateProductAPI", "POST");
		login.createorder_payload();
		login.user_calls_the_api_with_http_request("CreateOrderAPI", "POST");
		
	}
	

}
