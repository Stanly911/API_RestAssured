package GitHub;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class getRepo 
{

	public static void main(String[] args) 
	{
		//getRepo
		RestAssured.baseURI="https://api.github.com";
		String owner="Stanly911";
		given().header("Authorization","Bearer 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")
		.when().get("/repos/"+owner+"/Repo13")
		.then().assertThat().statusCode(404);
	}

}
