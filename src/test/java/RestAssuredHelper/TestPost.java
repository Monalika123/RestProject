package RestAssuredHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class TestPost {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo1\",\n" +
            "  \"body\": \"bar1\",\n" +
            "  \"userId\": \"11\" \n}";

    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
        System.out.println(response.asString());
    }
    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("foo1", response.jsonPath().getString("title"));
        Assert.assertEquals("bar1", response.jsonPath().getString("body"));
        Assert.assertEquals("11", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));

    }

    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(200, response.statusCode());
    }
}
