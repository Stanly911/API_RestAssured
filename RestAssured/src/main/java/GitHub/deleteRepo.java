package GitHub;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class deleteRepo 
{
	
	public static void main(String[] args) 
	{
		//deleteRepo
		RestAssured.baseURI="https://api.github.com";
		String owner="Stanly911";
		given().header("Authorization","Bearer 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")
		.when().delete("/repos/"+owner+"/MyRepo883")
		.then().assertThat().statusCode(204);
	}
}
