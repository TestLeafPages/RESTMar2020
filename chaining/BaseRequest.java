package chaining;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequest {
	
	public static String sys_id;
	
	@BeforeSuite
	public void init() {
		
		// End Point
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Authentication
		RestAssured.authentication = RestAssured.basic("admin", "wjGB2KUEyc6a");
		
	}

}
