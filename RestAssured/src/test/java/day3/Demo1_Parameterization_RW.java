package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Demo1_Parameterization_RW {
  @Test
  public void f() throws IOException {
	  
	  Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  String excelPath = "C:\\Users\\SUBHADEEP MALLICK\\git\\API_RestAssured\\RestAssured\\TestData.xlsx";
	  
	  FileInputStream fis = new FileInputStream(excelPath);
	  XSSFWorkbook wbk = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wbk.getSheet("Sheet1");
	  
	  JsonPath path = response.jsonPath();
	  
	  List<Object> rn = path.getList("rollNo");
	  List<Object> names = path.getList("name");
	  List<Object> stdx = path.getList("std");
	  
	  System.out.println(names);
	  
	  sheet.createRow(0).createCell(0).setCellValue("rn");
	  sheet.createRow(0).createCell(1).setCellValue("names");
	  sheet.createRow(0).createCell(2).setCellValue("stdx");
	  
	  for(int i=0; i<rn.size(); i++)
	  {
		  sheet.createRow(i+1).createCell(0).setCellValue(Integer.parseInt(rn.get(i).toString()));
		  sheet.getRow(i+1).createCell(1).setCellValue(names.get(i).toString());
		  sheet.getRow(i+1).createCell(2).setCellValue(stdx.get(i).toString());
	  }
	  
	  FileOutputStream fos = new FileOutputStream(excelPath);
	  wbk.write(fos);
	  wbk.close();
  }
}
