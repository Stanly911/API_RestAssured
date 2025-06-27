package day2_Post;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Demo_1 {
  @Test(enabled = false)
  public void f() {
	  RestAssured.baseURI = "https://reqres.in";
	  RequestSpecification req = RestAssured.given();
	  
	  req.queryParam("api_key", "reqres-free-v1");
	  req.header("Content-Type","application/json");
	  
	  JSONObject obj =new JSONObject();
	  
	  obj.put("name", "James");
	  obj.put("job", "Manager");
	  
	  req.body(obj.toString());
	  
	  Response msg = req.post("/api/users");
	  
	  Assert.assertEquals(msg.statusCode(), 201);
	  
	  System.out.println(msg.asString());
	   
	  
  }
  
  @Test
  public void f1()
  {
	  RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
	  RequestSpecification req = RestAssured.given();
//	  req.queryParam("token", "string");
	  req.header("Content-Type","application/json");
	  req.body("{\"id\": 99,\n"
	  		+ "  \"title\": \"MyName\",\n"
	  		+ "  \"dueDate\": \"2025-06-27T17:17:54.529Z\",\n"
	  		+ "  \"completed\": true\n"
	  		+ "}");
	  Response msg = req.post("/api/v1/Activities");
	  
//	  Assert.assertEquals(msg.statusCode(), 201);
	  
	  System.out.println(msg.getStatusCode());
	  
	  JsonPath path = msg.jsonPath();
	  String id = path.getString("id");
	  System.out.println(id);
	  
	  Response res = req.get("/api/v1/Activities/"+id);
	  System.out.println(res.jsonPath().getString("dueDate"));
  }
}
