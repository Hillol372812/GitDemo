package JiraApi_Demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import Files.Login_Payload;
import io.restassured.filter.session.SessionFilter;

public class SearchAllissues {

	public static void main(String[] args) throws IOException {
		
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session = new SessionFilter();

		
		
		
		//login API
		
				given().header("content-type","application/json").filter(session).body(Login_Payload.Login()).log().all().
				when().post("rest/auth/1/session").
				then().log().all().assertThat().statusCode(200);
				
			//Retrieve all issues:
				
				System.out.println("Starting of Retrieve all issues");
				
		given().header("content-type","application/json").header("content-type","application/json").body(Login_Payload.SearchAllIssue()).
		filter(session).when().get("/rest/api/2/search").then().log().all().statusCode(200);
		
		System.out.println("Starting of retrieve Issue");
		String	RetrieveIssueResponse =given().header("content-type","application/json").filter(session).
			pathParam("Keys", "10200").queryParam("fields", "comment").log().all()
			.when().get("rest/api/2/issue/{Keys}")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("RetrieveIssueResponse   :  : "+RetrieveIssueResponse);
		
		
		
		

	}

}
