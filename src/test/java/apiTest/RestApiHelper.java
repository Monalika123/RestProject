package apiTest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import model.RestResponse;

public class RestApiHelper {

	public static RestResponse performGetRequest(String url) {
		try {
			return performGetRequest(new URI(url)); 
		}
		catch(URISyntaxException e) {
			throw new RuntimeException(e.getMessage(),e); 
		}
	}
	
	public static RestResponse performGetRequest(URI uri) {
		HttpGet get = new HttpGet(uri);
		try(CloseableHttpClient client = HttpClientBuilder.create().build();
			CloseableHttpResponse response = client.execute(get))
		{
			ResponseHandler<String> body = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(),body.handleResponse(response));
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
}
