package day2_Post;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Demo_2 {
  @Test
  public void f() throws IOException {
	  
	  RestAssured.baseURI = "https://reqres.in";
	  RequestSpecification req = RestAssured.given();
	  
	  req.queryParam("api_key", "reqres-free-v1");
	  req.header("Content-Type","application/json");
	  
	  String excelPath = "C:\\Users\\SUBHADEEP MALLICK\\git\\API_RestAssured\\RestAssured\\TestData.xlsx";
	  
	  FileInputStream fis = new FileInputStream(excelPath);
	  XSSFWorkbook wbk = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wbk.getSheet("Sheet1");
	  
	  JSONObject obj = new JSONObject();
	  
	  for(int i=1; i<=sheet.getLastRowNum();i++)
	  {
		  obj.put("email", sheet.getRow(i).getCell(0).getNumericCellValue());
		  obj.put("password", sheet.getRow(i).getCell(1).getStringCellValue());
//		  obj.put("std", sheet.getRow(i).getCell(2).getStringCellValue());
	  }
	  
	  req.body(obj.toString());
	  
	  Response msg = req.post("/api/register");
	  
	  System.out.println(msg.getBody().asString());
	  wbk.close();
	  
  }
}
