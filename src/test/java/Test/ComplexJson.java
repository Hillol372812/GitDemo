package Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RestAssured_Demo.Demo.Payload;

public class ComplexJson {

	//@Test(dataProvider ="CommentData" )
	
	//public static void main(String[] args) 
	public static void Test(String name,String body)
	{
		
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		String Response =given().log().all().header("Content-Type","application/json").body(Payload.Comments(name,body))
		.when().post("posts/1/comments").
		then().log().all().statusCode(201).extract().response().asString();
		
		System.out.println("Print Response Body ::"+Response);
		
		
	}
	
	@DataProvider(name = "CommentData")
	
	public static Object[][] dataprovider() 
	{
		
		return new Object[][] {{"Hillol Mahata","Husband"},{"Supriti Mahata","Wife"},{"Joyshree Mahata","Sister"}};
	}

}
