package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Demo_4 {
  @Test
  public void f() {
	  Response response;
	  response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
	  
	  int statusCode = response.getStatusCode();
	  
	  String statusLine = response.getStatusLine();
	  
	  System.out.println("Status Code : "+statusCode);
	  System.out.println("Status Line : "+statusLine);
	  
  }
}
