package apiJava;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Hello world!
 *
 */

public class App {
	@Test
	public void getJsonPlaceholder() {
	Response response = given()
			.when()
			.get("https://jsonplaceholder.typicode.com/posts");
	System.out.println(response.body().asString());

		given().when().get("http://www.google.com").then().statusCode(200);

//	given()
//	.when()
//	.get("https://jsonplaceholder.typicode.com/posts")
//	.statusCode(200);
	}

}