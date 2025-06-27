package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Demo_6 {
  @Test
  public void f() {
	  Response response;
	  response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
	  
	  System.out.println(response.getHeader("Cache-Control"));
	  System.out.println(response.getHeader("Vary"));
  }
}
