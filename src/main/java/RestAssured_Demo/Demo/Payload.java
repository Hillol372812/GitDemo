package RestAssured_Demo.Demo;

public class Payload {
	
	public static String Comments(String Name, String string2)
	{
		String Response="{\r\n" + 
				"    \"postId\": 1,\r\n" + 
				"    \"id\": 1,\r\n" + 
				"    \"name\": \""+Name+"\",\r\n" + 
				"    \"email\": \"Eliseo@gardner.biz\",\r\n" + 
				"    \"body\": \""+string2+"\"\r\n" + 
				"  }";
		
		return Response;
	}

}
