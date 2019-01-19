package a_basic;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import responsepackage.Employee;
/**
@author Stavan S. Kodolikar
*
*
*/
public class BasicMethods_ForTestApi {
	FileInputStream fis;
	Properties p;
	
	@BeforeTest
	public void getGlobalProperties() throws FileNotFoundException {
	 p=new Properties();
	 fis =new FileInputStream("C:\\Users\\LENOVO\\Automation\\REST_API_Learning_Project\\src\\test\\java\\utils\\Global.properties");
	
	
	}
//BASE URI = http://dummy.restapiexample.com/
//TEST API's FOR TESTING
	@Test
	public void basicGetSingle_ForTestApi() {

		// BASE URI
		RestAssured.baseURI = p.getProperty("BaseURI");

		Response response = (Response) given().

				contentType(ContentType.JSON).and().

				when().get("/api/v1/employee/5167").

				then().assertThat().

				statusCode(200).and().

				header("Content-Type", equalTo("text/html; charset=UTF-8")).

				extract().body();

		Gson gson = new Gson();
		Employee employee = gson.fromJson(response.asString(), Employee.class);
		System.out.println("Employees Fetched is/are: "+employee.getEmployeeName());

	}

	@Test
	public void basicGetAll_ForTestApi() {

		// BASE URI
		RestAssured.baseURI = p.getProperty("BaseURI");

		Response response = (Response) given().

				contentType(ContentType.JSON).

				when().get("/api/v1/employees").

				then().assertThat().

				statusCode(200).and().

				header("Content-Type", equalTo("text/html; charset=UTF-8")).

				extract().body();

		Gson gson = new Gson();
		Employee[] employees = gson.fromJson(response.asString(), Employee[].class);
		System.out.println("Number of Employees Fetched : " + employees.length);

	}

	@Test
	public void basicPost_ForTestApi() {

		// BASE URI
		RestAssured.baseURI = p.getProperty("BaseURI");

		Response response = (Response) given().

				contentType(ContentType.JSON).

				body("{\"name\":\"Stavan\",\"salary\":\"10000\",\"age\":\"28\"}").

				when().post("/api/v1/create").

				then().assertThat().

				statusCode(200).and().

				header("Content-Type", equalTo("text/html; charset=UTF-8")).

				extract().body();

		 System.out.println(response.asString());

	}

	@Test
	public void basicPut_ForTestApi() {

		// BASE URI
		RestAssured.baseURI = p.getProperty("BaseURI");
		Response response = (Response) given().

				contentType(ContentType.JSON).

				body("{\"name\":\""+"NEWUPDATEDNAME"+"\",\"salary\":\"10000\",\"age\":\"28\"}").

				when().put("/api/v1/update/5167").

				then().assertThat().

				statusCode(200).and().

				header("Content-Type", equalTo("text/html; charset=UTF-8")).

				extract();
		JsonPath j=new JsonPath(response.asString());
		
		System.out.println(j.get("name"));

		Assert.assertEquals("NEWUPDATEDNAME",j.get("name"));

	}

}
