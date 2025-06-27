package day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Demo_7 {
  @Test
  public void f() {
	  Response response;
	  response = RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  JsonPath path = response.jsonPath();
	  
	  List<Object> list = path.getList("data");
	  
	  System.out.println(list);
	  System.out.println(list.size());

  }
}
