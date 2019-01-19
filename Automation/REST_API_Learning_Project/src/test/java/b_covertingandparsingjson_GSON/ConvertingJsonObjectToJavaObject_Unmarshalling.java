package b_covertingandparsingjson_GSON;

import org.testng.annotations.Test;

import com.google.gson.Gson;


/**
 * @author Stavan S. Kodolikar
 *
 *
 */
public class ConvertingJsonObjectToJavaObject_Unmarshalling {

	@Test
	public void jsonobject2javaobject(){
		
		String originalJson = "{\"accounting\":[{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":\"23\"},{\"firstName\":\"Mary\",\"lastName\":\"Smith\",\"age\":\"32\"}],\"sales\":[{\"firstName\":\"Sally\",\"lastName\":\"Green\",\"age\":\"27\"},{\"firstName\":\"Jim\",\"lastName\":\"Galley\",\"age\":\"41\"}]}";
		
		Gson gson=new Gson();
		
		JsonClass jsonClass =gson.fromJson(originalJson, JsonClass.class);
		
		System.out.println(jsonClass.getAccounting().get(0).getFirstName());
		System.out.println(jsonClass.getAccounting().get(0).getLastName());
		System.out.println(jsonClass.getAccounting().get(0).getAge());
		
		System.out.println(jsonClass.getAccounting().get(1).getFirstName());
		System.out.println(jsonClass.getAccounting().get(1).getLastName());
		System.out.println(jsonClass.getAccounting().get(1).getAge());
		
		System.out.println(jsonClass.getSales().get(0).getFirstName());
		System.out.println(jsonClass.getSales().get(0).getLastName());
		System.out.println(jsonClass.getSales().get(0).getAge());
		
		System.out.println(jsonClass.getSales().get(1).getFirstName());
		System.out.println(jsonClass.getSales().get(1).getLastName());
		System.out.println(jsonClass.getSales().get(1).getAge());
		
		
		
	}

}
