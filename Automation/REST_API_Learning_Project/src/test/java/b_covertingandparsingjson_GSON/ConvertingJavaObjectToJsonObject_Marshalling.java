package b_covertingandparsingjson_GSON;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.google.gson.Gson;
/**
@author Stavan S. Kodolikar
*
*
*/
public class ConvertingJavaObjectToJsonObject_Marshalling {

	

	@Test
	public void javaobject2jsonobject() {

		// Creating First Account Element with Hash Map;
		HashMap<Object, Object> ac1 = new HashMap<Object, Object>();
		ac1.put("firstName", "John");
		ac1.put("lastName", "Doe");
		ac1.put("age", "23");

		// Creating Second Account Element with Hash Map;
		HashMap<Object, Object> ac2 = new HashMap<Object, Object>();
		ac2.put("firstName", "Mary");
		ac2.put("lastName", "Smith");
		ac2.put("age", "32");

		// Creating Array of Two Account Elements;
		ArrayList<HashMap> ac = new ArrayList<HashMap>();
		ac.add(ac1);
		ac.add(ac2);

		// Creating First Sales Element with Hash Map;
		HashMap<Object, Object> sa1 = new HashMap<Object, Object>();
		sa1.put("firstName", "Sally");
		sa1.put("lastName", "Green");
		sa1.put("age", "27");

		// Creating Second Sales Element with Hash Map;
		HashMap<Object, Object> sa2 = new HashMap<Object, Object>();
		sa2.put("firstName", "Jim");
		sa2.put("lastName", "Galley");
		sa2.put("age", "41");

		// Creating Array of Two Account Elements;
		ArrayList<HashMap> sa = new ArrayList<HashMap>();
		sa.add(sa1);
		sa.add(sa2);

		// Creating Java Object Element with Hash Map;
		HashMap<Object, Object> javaObject = new HashMap<Object, Object>();
		javaObject.put("accounting", ac);
		javaObject.put("sales", sa);

		// Getting gson Object for Conversion;
		Gson gson = new Gson();

		String convertedJson = gson.toJson(javaObject);

		String originalJson = "{\"accounting\":[{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":\"23\"},{\"firstName\":\"Mary\",\"lastName\":\"Smith\",\"age\":\"32\"}],\"sales\":[{\"firstName\":\"Sally\",\"lastName\":\"Green\",\"age\":\"27\"},{\"firstName\":\"Jim\",\"lastName\":\"Galley\",\"age\":\"41\"}]}";
		
		System.out.println(convertedJson);
		System.out.println(originalJson);

		// Comparing both the Converted Json to Original Json returns true;
		System.out.println(convertedJson.equals(originalJson));

	}

}
