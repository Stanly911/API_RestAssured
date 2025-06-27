package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Demo_3 {
  @Test
  public void f() {
	  Response response;
	  response = RestAssured.get("");
	  
	  String id = response.getSessionId();
	  
	  String contentType = response.getContentType();
	  
	  System.out.println();
  }
}
