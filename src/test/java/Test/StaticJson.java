package Test;

import static io.restassured.RestAssured.given;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import java.io.IOException;


import io.restassured.path.json.JsonPath;


public class StaticJson {
	@Test
	public static void Test() throws IOException
	{	
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		String Response =given().log().all().header("Content-Type","application/json").body(GenerateStringFromResource("D:\\Eclipse_WorkSpace\\Request.json"))
		.when().post("posts/1/comments").
		then().log().all().statusCode(201).extract().response().asString();
		
		System.out.println("Print Response Body ::"+Response);
		
		JsonPath Json =new JsonPath(Response);
		
		String nmee =Json.get("name");
		System.out.println("name"+nmee);
	
	}
	
	
	public static String GenerateStringFromResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));

	}
	
	
	
	

}
