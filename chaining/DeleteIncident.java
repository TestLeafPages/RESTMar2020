package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{
	
	// package.class.method
	@Test(dependsOnMethods="chaining.PostIncident.createIncident")
	public void deleteIncident() {

		/*
		 * 1) EndPoint (URL+Resources)
		 * 2) Authorization (Basic)
		 * 3) Request Type: Get
		 * 4) Content Type: Json
		 */
		
		// Request to get
		Response response = RestAssured
				.given()
				.log().all()
				.delete(sys_id);
		
		// Print the response status code
		int statusCode = response.getStatusCode();
		System.out.println("The status code is "+statusCode);
		
		// Print the response time
		long time = response.getTime();
		System.out.println("The response time is "+time);
		
		// Response content type
		System.out.println("Response output type "+response.getContentType());
		
		// How many incidents?
		response.prettyPrint();
		
		
			
	}

}



