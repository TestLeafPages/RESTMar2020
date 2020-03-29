package basics;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident {

	// Goal is to find the count of all incidents in Servicenow
	// Print the incident numbers
	public static void main(String[] args) {

		/*
		 * 1) EndPoint (URL+Resources)
		 * 2) Authorization (Basic)
		 * 3) Request Type: Get
		 * 4) Content Type: Json
		 */
		
		// End Point
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Authentication
		RestAssured.authentication = RestAssured.basic("admin", "wjGB2KUEyc6a");
		
		// Request to get
		Response response = RestAssured
				.delete("160c0e122fbf00100510d6ab2799b64c");
		
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



