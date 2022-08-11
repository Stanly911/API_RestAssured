package GitHub;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class repoReqChaining 
{
	@Test
	public void Repo()
	{

		RestAssured.baseURI="https://api.github.com";
		
		Random randomNum= new Random();
		int max=1000;
		String randomName="MyRepo"+randomNum.nextInt(max);
		System.out.println(randomName);
		
		//createRepo
		
				given().header("Content-type","application/json")
				.header("Authorization","Bearer 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")
				.body("{\r\n"
						+ "    \"name\": \""+randomName+"\",\r\n"
						+ "    \"description\": \"I created a repo\"\r\n"
						+ "}")
				.when().post("/user/repos")
				.then().assertThat().statusCode(201);
				
		//UpdateRepo
				
				String owner="Stanly911";
				given().header("Content-type","application/json")
				.header("Authorization","Bearer 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")
				.body("{\r\n"
						+ "\"description\":\"I updated a repo\"\r\n"
						+ "}")
				.when().patch("/repos/"+owner+"/"+randomName+"")
				.then().log().all().assertThat().statusCode(200);
				
		//deleteRepo
				
				given().header("Authorization","Bearer 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")
				.when().delete("/repos/"+owner+"/"+randomName+"")
				.then().log().all().assertThat().statusCode(204);
				
		//getRepo
			
				given().header("Authorization","Bearer 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")
				.when().get("/repos/"+owner+"/"+randomName+"")
				.then().log().all().assertThat().statusCode(404);
	}
}
