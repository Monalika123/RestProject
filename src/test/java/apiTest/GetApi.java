package apiTest;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import io.restassured.*;

public class GetApi {
	@Test
	public void makesuregoogleIsup() {
	Response response = given()
			.when()
			.get("https://jsonplaceholder.typicode.com/users/1");
	System.out.println(response.body().asString());

	}
	
	@Test
	public void statusCode() {
	given()
			.when()
			.get("https://jsonplaceholder.typicode.com/users/1")
			.then()
			.statusCode(200);

	}
}
