package GitHub;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class patchRepo 
{

	public static void main(String[] args) 
	{
		//UpdateRepo
		
			RestAssured.baseURI="https://api.github.com";
			String owner="Stanly911";
			given().header("Content-type","application/json").header("Authorization","Bearer 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")
			.body("{\r\n"
					+ "\"description\":\"I updated a repo\"\r\n"
					+ "}")
			.when().patch("/repos/"+owner+"/Repo13")
			.then().log().all().assertThat().statusCode(200);

	}

}
