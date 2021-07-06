package model;

public class RestResponse {
	private int statusCode;
	public String responseBody;
	
	public int getStatusCode() {
		return statusCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	
	public RestResponse(int statusCode,String responseBody) {
	  this.statusCode = 	statusCode;
	  this.responseBody = 	responseBody;
	  
	}

	public String toString() {
		return String.format("Status Code : %1s Body : %2s", this.statusCode,this.responseBody);
	}

}
