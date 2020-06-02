package JiraApi_Demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class QueryParam {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter session = new SessionFilter();
		
		//login API
		
		given().header("content-type","application/json").filter(session).body("{\r\n" + 
				"    \"username\": \"Hillol\",\r\n" + 
				"    \"password\": \"Password@123\"\r\n" + 
				"}").log().all().
		when().post("rest/auth/1/session").
		then().log().all().assertThat().statusCode(200);
		
		//Add comment
		
		System.out.println("***Staring of Add Comment Section  ****");
		
		String message="Adding comment using RestAssured on 5/7/2020";
	String response	=given().header("content-type","application/json").filter(session).
		pathParam("Key", "10200").body("{\r\n" + 
				"    \"body\": \""+message+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").log().all()
		.when().post("rest/api/2/issue/{Key}/comment").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
	     
	JsonPath RS1 = new JsonPath(response);
	String id=RS1.get("id");
	
		//Retrieve Issue
		
		System.out.println("Starting of retrieve Issue");
	String	RetrieveIssueResponse =given().header("content-type","application/json").filter(session).
		pathParam("Keys", "10200").queryParam("fields", "comment").log().all()
		.when().get("rest/api/2/issue/{Keys}")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println("RetrieveIssueResponse   :  : "+RetrieveIssueResponse);
	

	JsonPath RS = new  JsonPath(RetrieveIssueResponse);
	
	int count =RS.getInt("fields.comment.comments.size()");
	System.out.println("Value of Count : "+count);
	
	for(int i=0;i<=count;i++)		
		
	{
		String expectId =RS.get("fields.comment.comments["+i+"].id");
		if (expectId.equalsIgnoreCase(id)) {
		
		System.out.println("Comment Details : ");
		System.out.println(RS.get("fields.comment.comments["+i+"].body"));
		System.out.println(RS.get("fields.comment.comments["+i+"].id"));
		
		}
		
		else {
			
		 }
		
		
	  }
	
	//Search all issue assigned to the user.
	
	
	}

}
