package basics;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostIncidentFromDP {


	// Step 2: Create a dataprovider
	@DataProvider(name="files", indices= {0})
	public String[][] getFiles() {

		String[][] fileNames = new String[2][1];

		fileNames[0][0] = "./data1.json";
		fileNames[1][0] = "./data2.json";

		return fileNames;

	}

	// Step 1) Convert main method to TestNg method + add @Test
	// Step 3) Receive the data and pass to the @Test method
	@Test(dataProvider="files")
	public void createIncident(String fileName){

		File jsonFile = new File(fileName);

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



