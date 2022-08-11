package GitHub;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.Random;

public class postRepo 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://api.github.com";
		
		Random randomNum= new Random();
		int max=1000;
		String randomName="MyRepo"+randomNum.nextInt(max);
		System.out.println(randomName);
		
		//createRepo
				given().header("Content-type","application/json").header("Authorization","Bearer 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")
				.body("{\r\n"
						+ "    \"name\": \""+randomName+"\",\r\n"
						+ "    \"description\": \"I created a repo\"\r\n"
						+ "}")
				.when().post("/user/repos")
				.then().assertThat().statusCode(201);

	}

}
