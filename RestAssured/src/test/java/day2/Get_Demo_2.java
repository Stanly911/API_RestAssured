package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Demo_2 {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://dummy.restapiexample.com";
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  Response res = httpRequest.request(Method.GET,"/api/v1/employees");
	  
	  String responseBody = res.getBody().asString();
	  
	  System.out.println(responseBody);
	  
  }
}
