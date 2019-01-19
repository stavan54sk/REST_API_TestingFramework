
package b_covertingandparsingjson_GSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sale {

@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("age")
@Expose
private String age;

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getAge() {
return age;
}

public void setAge(String age) {
this.age = age;
}


public static void main(String[] args) {

	Sale sale1=new Sale();
	sale1.setAge("27");
	sale1.setFirstName("Sally");
	sale1.setLastName("Green");
	
	Sale sale2=new Sale();
	sale2.setAge("41");
	sale2.setFirstName("Jim");
	sale2.setLastName("Galley");
	
}

}