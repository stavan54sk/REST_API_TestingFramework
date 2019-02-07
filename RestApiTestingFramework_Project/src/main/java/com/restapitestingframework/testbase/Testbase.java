package com.restapitestingframework.testbase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
/**
@author Stavan S. Kodolikar
*
*
*/
public class Testbase {

	public Response createCustomer(String body) {
	//	System.out.println(body);
	//	System.out.println(RestApis.baseUri+RestApis.createEmployeeEndpoint);
		return  given().
			contentType(ContentType.JSON).
			body(body).
		when().
			post(RestApis.baseUri+RestApis.createEmployeeEndpoint).
		then().
			assertThat().statusCode(200).and().
			assertThat().header("content-type", equalTo("text/html; charset=UTF-8")).
		extract().
				response();

	}
	
		
	public Response updateCustomer(String body,String updatingEmployee) {
		return  given().
			contentType(ContentType.JSON).
			body(body).
		when().
			put(RestApis.baseUri+RestApis.updateEmployeeEndpoint+updatingEmployee).
		then().
			assertThat().statusCode(200).and().
			assertThat().header("content-type", equalTo("text/html; charset=UTF-8")).
		extract().
			response();
	}
	
	
	
	public Response getCustomer(String gettingEmployee) {
		System.out.println(gettingEmployee);
		System.out.println(RestApis.baseUri+RestApis.getEmployeeEndpoint+gettingEmployee);
		return  given().
			contentType(ContentType.JSON).
		when().
			get(RestApis.baseUri+RestApis.getEmployeeEndpoint+gettingEmployee).
		then().
			assertThat().statusCode(200).and().
			assertThat().header("content-type", equalTo("text/html; charset=UTF-8")).
		extract().
			response();
	}
	
	
	public Response deleteCustomer(String deletingEmployee) {
		System.out.println(deletingEmployee);
		System.out.println(RestApis.baseUri+RestApis.deleteEmployeeEndpoint+deletingEmployee);
		return  given().
			contentType(ContentType.JSON).
		when().
			delete(RestApis.baseUri+RestApis.deleteEmployeeEndpoint+deletingEmployee).
		then().
			assertThat().statusCode(200).and().
			assertThat().header("content-type", equalTo("text/html; charset=UTF-8")).
		extract().
			response();
	}
	
}
