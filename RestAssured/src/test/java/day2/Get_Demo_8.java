package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Demo_8 {
  @Test
  public void f() {
	  Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  JsonPath path = response.jsonPath();
	  
	  System.out.println(path.getList("data").size());
	  
	  System.out.println("support :"+path.getString("support"));
	  
	  System.out.println("data :"+path.getString("data"));
	  
	  for(int i=0;i<path.getList("data").size();i++)
	  {
		  System.out.println("data : "+ path.get("data["+i+"]").toString());
		  System.out.println("id : "+ path.get("data["+i+"].id").toString());
	  }
  }
}
