package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidents {

	@Test
	public void getIncidents() {

		/*
		 * 1) EndPoint (URL+Resources)
		 * 2) Authorization (Basic)
		 * 3) Request Type: Get
		 * 4) Content Type: Json
		 */
		
		
		// Request to get
		Response response = RestAssured.get();
		
		// Print the response status code
		int statusCode = response.getStatusCode();
		System.out.println("The status code is "+statusCode);
		
		// Print the response time
		long time = response.getTime();
		System.out.println("The response time is "+time);
		
		// Response content type
		System.out.println("Response output type "+response.getContentType());
		
		// How many incidents?
		//response.prettyPrint();
		JsonPath jsonResponse = response.jsonPath();
		
		List<String> listOfIncidents = jsonResponse.getList("result.number");
		System.out.println(listOfIncidents.size());
		
		// print all incident number
		for (String eachIncident : listOfIncidents) {
			System.out.println(eachIncident);
		}
		
			
	}

}



