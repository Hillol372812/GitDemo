package JiraApi_Demo;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class AddAttachment {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		String Response =given().headers("content-type", "application/json").body("{\r\n" + 
				"    \"username\": \"Hillol\",\r\n" + 
				"    \"password\": \"Password@123\"\r\n" + 
				"}").filter(session).log().all().
		when().post("rest/auth/1/session").
		then().log().all().statusCode(200).extract().response().asString();
		
		//AddAttachment
		
		given().headers("X-Atlassian-Token","no-check").headers("Content-Type","multipart/form-data").pathParam("key", "10301")
		.multiPart("File", new File("RestAssured.txt")).filter(session).when().post("/rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);

	}

}
