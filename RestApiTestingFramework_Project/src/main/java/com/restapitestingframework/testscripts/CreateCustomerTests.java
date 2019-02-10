package com.restapitestingframework.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.restapitestingframework.helper.ExcelHelper;
import com.restapitestingframework.requestpojos.CreateCutomerRequest;
import com.restapitestingframework.responsepojos.CreateCustomerResponse;
import com.restapitestingframework.testbase.Testbase;

import io.restassured.response.Response;
/**
@author Stavan S. Kodolikar
*
*
*/
public class CreateCustomerTests extends Testbase{
	
	

	
	@Test(dataProvider="createCustomerFirstTestDataProvider")
	public void createCustomerFirstTest(String srNum,String run,String testCase,String name,String salary,String age,String id,String status) throws IOException
	{
	
		
		if (run.equalsIgnoreCase("true")) {
			
			status="NO RUN";
			extentTest.log(Status.INFO, " POST Call for Customer Creation ");
			CreateCutomerRequest createCutomerRequest = new CreateCutomerRequest();
			createCutomerRequest.setName(name);
			createCutomerRequest.setSalary(salary);
			createCutomerRequest.setAge(age);

			Gson gson = new Gson();
			String createCutomerRequestString = gson.toJson(createCutomerRequest);
			
			extentTest.log(Status.INFO, " POJO Class Initialized for Customer Creation ");
			
			Response response = createCustomer(createCutomerRequestString);

			CreateCustomerResponse createCustomerResponse = gson.fromJson(response.asString(),
					CreateCustomerResponse.class);
			
			extentTest.log(Status.INFO, " POST Call for Customer Creation is Success");

			System.out.println("Age: " + createCustomerResponse.getAge());
			System.out.println("Id: " + createCustomerResponse.getId());
			System.out.println("Name: " + createCustomerResponse.getName());
			System.out.println("Salary: " + createCustomerResponse.getSalary());
			System.out.println("########################################################################################################################################################");
			status="PASSED";
			

		}
		else
		{
			throw new SkipException("Test Skipped with Test Data " + srNum + "," + run + "," + testCase + "," + name
					+ "," + salary + "," + age + "," + id + "," + status);
		}
		
		
	}
	
	
	@DataProvider
	public Object[][] createCustomerFirstTestDataProvider() throws IOException
	{
		Object[][] data =ExcelHelper.getExcelData("CreateCustomerTests");
		return data;
		
	}
	


	

}
