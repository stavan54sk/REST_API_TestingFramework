package com.restapitestingframework.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
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
public class GetCutomerTests extends Testbase{
	public CreateCutomerRequest createCutomerRequest;
	public UpdateCustomerRequest updateCustomerRequest;
	public CreateCustomerResponse createCustomerResponse;
	public UpdateCustomerRequest updateCustomerResponse;
	public GetCustomerResponse getCustomerResponse;
	int index;String[] indexArray=new String[2] ;
	
	
	
	
	@Test(dataProvider="createCustomerTestDataProvider")
	public void createCustomerTest(String name,String salary,String age)
	{	
		createCutomerRequest=new CreateCutomerRequest();
		createCutomerRequest.setName(name);
		createCutomerRequest.setSalary(salary);
		createCutomerRequest.setAge(age);
		
		Gson gson=new Gson();
		String createCutomerRequestString=gson.toJson(createCutomerRequest);
	
		Response response=createCustomer(createCutomerRequestString);
		System.out.println(response.asString());
		
		createCustomerResponse=gson.fromJson(response.asString(), CreateCustomerResponse.class);
		
		System.out.println(" Created Age "+createCustomerResponse.getAge());
		System.out.println(" Created Id "+createCustomerResponse.getId());
		System.out.println(" Created Name "+createCustomerResponse.getName());
		System.out.println(" Created Salary "+createCustomerResponse.getSalary());
		System.out.println(" ******************************************************************************************************************************************** ");
		indexArray[index]=createCustomerResponse.getId();
		if(index==indexArray.length-1)
		{
			index=0;
		}
		else
		{
		index++;
		}
	}

	@DataProvider
	public Object[][] createCustomerTestDataProvider()
	{
		Object[][] data =new Object[2][3];
		data[0][0]="OLDRESTAPITESTER00";
		data[0][1]="1234500";
		data[0][2]="3100";
		
		data[1][0]="OLDRESTAPITESTER11";
		data[1][1]="1234511";
		data[1][2]="3111";
		return data;
		
	}


	
	@Test(dataProvider = "updateCustomerTestDataProvider",dependsOnMethods={"createCustomerTest"})
	public void updateCustomerTest(String name, String salary, String age) {
		updateCustomerRequest = new UpdateCustomerRequest();
		updateCustomerRequest.setName(name);
		updateCustomerRequest.setSalary(salary);
		updateCustomerRequest.setAge(age);
		
		Gson gson = new Gson();
		String updateCustomerRequestString = gson.toJson(updateCustomerRequest);

		Response response = updateCustomer(updateCustomerRequestString,indexArray[index]);

		updateCustomerResponse = gson.fromJson(response.asString(), UpdateCustomerRequest.class);

		System.out.println(" Updated Age " + updateCustomerResponse.getAge());
		System.out.println(" Updated Name " + updateCustomerResponse.getName());
		System.out.println(" Updated Salary " + updateCustomerResponse.getSalary());
		System.out.println(" ******************************************************************************************************************************************** ");
		if(index==indexArray.length-1)
		{
			index=0;
		}
		else
		{
		index++;
		}
	}

	@DataProvider
	public Object[][] updateCustomerTestDataProvider()
	{
		Object[][] data =new Object[2][3];
		data[0][0]="OLDRESTAPITESTER00";
		data[0][1]="999900";
		data[0][2]="9900";
		
		data[1][0]="OLDRESTAPITESTER11";
		data[1][1]="999911";
		data[1][2]="9911";
		return data;
		
	}
	
	
	@Test(dependsOnMethods={"updateCustomerTest"})
	public void getCustomerTest() {

		for (int i = 0; i < indexArray.length; i++) {

			Response response = getCustomer(indexArray[i]);

			Gson gson = new Gson();
			getCustomerResponse = gson.fromJson(response.asString(), GetCustomerResponse.class);

			System.out.println(" Age get" + getCustomerResponse.getEmployeeAge());
			System.out.println(" Name get " + getCustomerResponse.getEmployeeName());
			System.out.println(" Salary get " + getCustomerResponse.getEmployeeSalary());
			System.out.println(" Id get " + getCustomerResponse.getId());
			System.out.println(" Profile get " + getCustomerResponse.getProfileImage());
			System.out.println(" ******************************************************************************************************************************************** ");
		}

	}

}
