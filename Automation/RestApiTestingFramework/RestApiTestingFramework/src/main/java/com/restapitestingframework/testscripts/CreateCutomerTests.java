package com.restapitestingframework.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restapitestingframework.requestjsons.CreateCustomerResponse;
import com.restapitestingframework.requestpojos.CreateCutomerRequest;
import com.restapitestingframework.testbase.Testbase;

import io.restassured.response.Response;

public class CreateCutomerTests extends Testbase{
	
	
	@Test(dataProvider="createCustomerFirstTestDataProvider")
	public void createCustomerFirstTest(String name,String salary,String age)
	{
		CreateCutomerRequest createCutomerRequest=new CreateCutomerRequest();
		createCutomerRequest.setName(name);
		createCutomerRequest.setSalary(salary);
		createCutomerRequest.setAge(age);
		
		Gson gson=new Gson();
		String createCutomerRequestString=gson.toJson(createCutomerRequest);
	
		Response response=createCustomer(createCutomerRequestString);
		
		CreateCustomerResponse createCustomerResponse=gson.fromJson(response.asString(), CreateCustomerResponse.class);
		
		System.out.println("Age"+createCustomerResponse.getAge());
		System.out.println("Id"+createCustomerResponse.getId());
		System.out.println("Name"+createCustomerResponse.getName());
		System.out.println("Salary"+createCustomerResponse.getSalary());
		
	}
	
	
	@DataProvider
	public Object[][] createCustomerFirstTestDataProvider()
	{
		Object[][] data =new Object[1][3];
		data[0][0]="RESTAPITESTER";
		data[0][1]="12345";
		data[0][2]="30";
		return data;
		
	}

}
