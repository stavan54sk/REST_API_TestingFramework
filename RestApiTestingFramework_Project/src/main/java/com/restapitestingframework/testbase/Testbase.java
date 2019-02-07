package com.restapitestingframework.testbase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.restapitestingframework.helper.ExtentReportHelper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author Stavan S. Kodolikar
 *
 *
 */
public class Testbase {
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	
	@BeforeSuite
	public void beforeSuite() {
		extentReports=ExtentReportHelper.getReport();
		
	}
	
	
	@BeforeClass
	public void beforeClass() {
		extentTest=extentReports.createTest(getClass().getName());
		
	}
	
	@AfterSuite
	public void afterSuite() {
		extentReports.flush();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		extentTest.log(Status.INFO, method.getName() + "**************started***************");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getName() + "  pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getThrowable());
		}

	}

	public Response createCustomer(String body) {
		// System.out.println(body);
		// System.out.println(RestApis.baseUri+RestApis.createEmployeeEndpoint);
		return given().contentType(ContentType.JSON).body(body).when()
				.post(RestApis.baseUri + RestApis.createEmployeeEndpoint).then().assertThat().statusCode(200).and()
				.assertThat().header("content-type", equalTo("text/html; charset=UTF-8")).extract().response();

	}

	public Response updateCustomer(String body, String updatingEmployee) {
		return given().contentType(ContentType.JSON).body(body).when()
				.put(RestApis.baseUri + RestApis.updateEmployeeEndpoint + updatingEmployee).then().assertThat()
				.statusCode(200).and().assertThat().header("content-type", equalTo("text/html; charset=UTF-8"))
				.extract().response();
	}

	public Response getCustomer(String gettingEmployee) {
		System.out.println(gettingEmployee);
		System.out.println(RestApis.baseUri + RestApis.getEmployeeEndpoint + gettingEmployee);
		return given().contentType(ContentType.JSON).when()
				.get(RestApis.baseUri + RestApis.getEmployeeEndpoint + gettingEmployee).then().assertThat()
				.statusCode(200).and().assertThat().header("content-type", equalTo("text/html; charset=UTF-8"))
				.extract().response();
	}

	public Response deleteCustomer(String deletingEmployee) {
		System.out.println(deletingEmployee);
		System.out.println(RestApis.baseUri + RestApis.deleteEmployeeEndpoint + deletingEmployee);
		return given().contentType(ContentType.JSON).when()
				.delete(RestApis.baseUri + RestApis.deleteEmployeeEndpoint + deletingEmployee).then().assertThat()
				.statusCode(200).and().assertThat().header("content-type", equalTo("text/html; charset=UTF-8"))
				.extract().response();
	}

}
