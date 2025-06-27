package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Get_Demo_5 {
  @Test
  public void f() {
	  Response response;
	  response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
	  
	  Headers headers = response.getHeaders();
	  System.out.println(headers);
  }
}
