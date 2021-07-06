package apiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import model.RestResponse;

public class GetApiTest {
	
	@Test
	public void testGetRequest() {
		String url = "https://jsonplaceholder.typicode.com/users/1";
		RestResponse response = RestApiHelper.performGetRequest(url);
        System.out.println(response.toString());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
	}
}
