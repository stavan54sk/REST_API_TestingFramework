package com.restapitestingframework.testscripts;

import java.io.IOException;
import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.restapitestingframework.helper.ExcelHelper;
import com.restapitestingframework.requestpojos.CreateCutomerRequest;
import com.restapitestingframework.requestpojos.UpdateCustomerRequest;
import com.restapitestingframework.responsepojos.CreateCustomerResponse;
import com.restapitestingframework.responsepojos.GetCustomerResponse;
import com.restapitestingframework.testbase.Testbase;

import io.restassured.response.Response;
/**
@author Stavan S. Kodolikar
*
*
*/
public class GetCustomerTests extends Testbase{
	public CreateCutomerRequest createCutomerRequest;
	public UpdateCustomerRequest updateCustomerRequest;
	public CreateCustomerResponse createCustomerResponse;
	public UpdateCustomerRequest updateCustomerResponse;
	public GetCustomerResponse getCustomerResponse;
	int index=0;HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
	
	

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
			
			hashMap.put(index++, createCustomerResponse.getId());
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
	
	
	
	@Test(dataProvider = "updateCustomerTestDataProvider")
	public void updateCustomerTest(String srNum,String run,String testCase,String name,String salary,String age,String id,String status) {

		if (run.equalsIgnoreCase("true")) {
			if (index == hashMap.size() - 1) {
				index = -1;
			}
			index++;
			
			status="NO RUN";
			extentTest.log(Status.INFO, " PUT Call for Customer Updation ");
			updateCustomerRequest = new UpdateCustomerRequest();
			updateCustomerRequest.setName(name);
			updateCustomerRequest.setSalary(salary);
			updateCustomerRequest.setAge(age);

			Gson gson = new Gson();
			String updateCustomerRequestString = gson.toJson(updateCustomerRequest);
			
			extentTest.log(Status.INFO, " POJO Class Initialized for Customer Creation ");

			Response response = updateCustomer(updateCustomerRequestString, hashMap.get(index));

			updateCustomerResponse = gson.fromJson(response.asString(), UpdateCustomerRequest.class);
			
			extentTest.log(Status.INFO, " PUT Call for Customer Updation is Success ");

			System.out.println(" Updated Age " + updateCustomerResponse.getAge());
			System.out.println(" Updated Name " + updateCustomerResponse.getName());
			System.out.println(" "
					+ "Updated Salary " + updateCustomerResponse.getSalary());
			System.out.println("########################################################################################################################################################");


		}
		else
		{
			throw new SkipException("Test Skipped with Test Data " + srNum + "," + run + "," + testCase + "," + name
					+ "," + salary + "," + age + "," + id + "," + status);
		}
	}
		
		
		
	
	

	
	@DataProvider
	public Object[][] updateCustomerTestDataProvider() throws IOException
	{
		Object[][] data =ExcelHelper.getExcelData("UpdateCustomerTests");
		return data;
		
	}
	
	@Test(dependsOnMethods={"updateCustomerTest"})
	public void getCustomerTest() {

		for (index = 0; index < hashMap.size(); index++) {

			Response response = getCustomer(hashMap.get(index));

			Gson gson = new Gson();
			getCustomerResponse = gson.fromJson(response.asString(), GetCustomerResponse.class);

			extentTest.log(Status.INFO, " GET Call for Customer Getting is Success ");
			
			System.out.println(" Age get" + getCustomerResponse.getEmployeeAge());
			System.out.println(" Name get " + getCustomerResponse.getEmployeeName());
			System.out.println(" Salary get " + getCustomerResponse.getEmployeeSalary());
			System.out.println(" Id get " + getCustomerResponse.getId());
			System.out.println(" Profile get " + getCustomerResponse.getProfileImage());
			System.out.println(" ******************************************************************************************************************************************** ");
		}

	}

}
