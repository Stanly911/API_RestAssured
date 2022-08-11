package Data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class DataProviders 
{
	@Test(dataProvider="RepoData")
	public void Repo(String repoName)
	{
		RestAssured.baseURI="https://api.github.com";
		given().header("Content-Type","application/json").header("Authorization","Bearer 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")
		.body("{\r\n" + 
				"    \"name\":\""+repoName+"\",\r\n" + 
				"    \"description\":\"I created a repo\"\r\n" + 
				"}")
		.when().post("/user/repos")
		.then().log().all().assertThat().statusCode(201);
	}
	
@DataProvider(name="RepoData")
public Object[][] Data()
		//array-Set of data
		//multidimensional array - set of arrays
	{
		return new Object[][] {{"Repo1"},{"Repo2"},{"Repo3"}};
	}
}
