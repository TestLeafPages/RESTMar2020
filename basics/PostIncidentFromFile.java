package basics;

import java.io.File;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostIncidentFromFile {

	// Goal is to find the count of all incidents in Servicenow
	// Print the incident numbers
	public static void main(String[] args) {

		File jsonFile = new File("./data1.json");
		
		// End Point
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Authentication
		RestAssured.authentication = RestAssured.basic("admin", "wjGB2KUEyc6a");
		
		// Request to get
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFile)				
				.post();
		
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



