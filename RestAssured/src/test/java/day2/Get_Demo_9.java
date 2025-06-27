package day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Demo_9 {
  @Test
  public void f() {
	  Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  JsonPath path = response.jsonPath();
	  
	  List<Object> list = path.getList("data");
	  System.out.println("Total number of data : "+list.size());
	  
	  //1
	  System.out.println("Using Java 8 \n");
	  list.forEach(System.out::println);
	  System.out.println(" \n");
	  
	  //2
	  System.out.println("Using Advance for loop \n");
	  for(Object n:list)
	  {
		  System.out.println(n);
	  }
	  System.out.println(" \n");
  }
}
