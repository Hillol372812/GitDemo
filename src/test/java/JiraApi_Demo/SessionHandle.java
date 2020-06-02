package JiraApi_Demo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class SessionHandle {

	public static void main(String[] args) {
		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter session = new SessionFilter();
		
		String Response =given().headers("content-type", "application/json").body("{\r\n" + 
				"    \"username\": \"Hillol\",\r\n" + 
				"    \"password\": \"Password@123\"\r\n" + 
				"}").filter(session).log().all().
		when().post("rest/auth/1/session").
		then().log().all().statusCode(200).extract().response().asString();
		
		given().pathParam("key", "10100").headers("content-type", "application/json").body("{\r\n" + 
				"    \"body\": \"This is my 3rd ****Testing **** comment \",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(session).log().all().
		when().post("rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201);
		
		

	}

}
