package Files;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import RestAssured_Demo.Demo.TestdataFile;

public class Login_Payload {
	
public static HashMap<String, Object> Login() throws IOException
		{
	HashMap<String, Object>  Login = new HashMap<String, Object>();
	//TestdataFile data = new TestdataFile();
	
	Login.put("username", TestdataFile.TestData().get(1));
	Login.put("password", TestdataFile.TestData().get(2));
	
			return Login;
			
		}

public static HashMap<String, Object> SearchAllIssue()
{
	
	HashMap<String, Object> SearchAlIssue = new HashMap<String, Object>();
	
	SearchAlIssue.put("SearchAlIssue", "project = RES");
	SearchAlIssue.put("startAt", "0");
	SearchAlIssue.put("maxResults", "4");
	SearchAlIssue.put("fields",Arrays.asList("id","key"));
	
	return SearchAlIssue;
	
	
	
	
}

	

}
