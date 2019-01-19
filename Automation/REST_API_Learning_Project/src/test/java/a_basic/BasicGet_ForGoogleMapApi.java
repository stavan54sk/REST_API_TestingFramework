package a_basic;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import javax.swing.text.AbstractDocument.Content;
/**
@author Stavan S. Kodolikar
*
*
*/
public class BasicGet_ForGoogleMapApi {

	// REQUEST YOU TO GENERATE API KEY BEFORE THE GET CALL WITH HELP OF BELOW LINK
	// https://www.youtube.com/watch?v=ozgVhnJ7SOM
	// https://developers.google.com/maps/documentation/javascript/get-api-key

	@SuppressWarnings("deprecation")
	@Test
	public void basicGet_ForGoogleMapApi() {

		// BASE URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		Response response =
				// TYPE CASTED THE RESPONSE TO RESPONSE OBJECT
				(Response) 
				given().queryParameter("address", "1600+Amphitheatre+Parkway,+Mountain+View,+CA").and().
// *******************PLEASE ENTER THE API KEY GENERATED HERE******************************
						queryParameter("key", "PLEASE ENTER GENERATED KEY").and().

						contentType(ContentType.JSON).

				when().
						// RESOURCE
						get("/maps/api/geocode/json").

				then().assertThat().

						statusCode(200).and().

						header("Content-Type", equalTo("application/json; charset=UTF-8")).

				extract().body();

		System.out.println(response.asString());

	}

}
