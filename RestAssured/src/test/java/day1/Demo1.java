package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1 {
  @Test
  public void f() {
	  Response r;
	  r = RestAssured.get("	https://dummy.restapiexample.com/api/v1/employees");
	  System.out.println(r);
	  
	  System.out.println("Body : "+r.getBody().toString());
	  System.out.println("Body : "+r.getBody().asString());
  }
}
