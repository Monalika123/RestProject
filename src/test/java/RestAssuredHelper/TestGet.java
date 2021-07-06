package RestAssuredHelper;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class TestGet {

    @Test
    public void testGet() throws URISyntaxException {
      Response response =given()
              .auth()
              .basic("AKIAW6BO6BW6NQKA6H74", "acfITrHOh+/FIeMoqYx5xsc0EfgCgclroKmGNL8i")
              .log()
              .all()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://3fzqacp5c8.execute-api.eu-west-3.amazonaws.com/cand1/assets/trailer/from/03b1570e912fccab096c8ac8091f2611"));
     System.out.println(response.asString());
    }

    @Test
    public void petStoreGet() throws URISyntaxException {
        Response response =given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://petstore.swagger.io/v2/pet/findByStatus?status=available"));
        String s = response.asString();
        System.out.println(s);
    }
//then() - validation of response using then()
    @Test
    public void testGet_using_Then() throws URISyntaxException {
        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://jsonplaceholder.typicode.com/users/1"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
    @Test
    public void test_NotFoundStatusCode() throws URISyntaxException {
        //   Response response =given()
        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://jsonplaceholder.typicode.com/users/11"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
        //   System.out.println(response.asString());
    }
//thenReturn() - Capture the status code / any other info : thenReturn
    @Test
    public void test_StatusCode() throws URISyntaxException {
        int code = given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://jsonplaceholder.typicode.com/users/1"))
        .thenReturn()
        .statusCode();
        System.out.println( "status code : " + code);
        Assert.assertEquals(HttpStatus.SC_OK,code);
    }

    @Test
    public void test_StatusCode_notFound() throws URISyntaxException {
        int code = given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://jsonplaceholder.typicode.com/users/11"))
                .thenReturn()
                .statusCode();
        System.out.println( "status code : " + code);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND,code);
    }

    @Test
    public void test_theReturnBody() throws URISyntaxException {
        String body = given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("https://jsonplaceholder.typicode.com/users/1"))
                .thenReturn()
                .body()
                .asString();
        System.out.println( "status code : " + body);
    }

    @Test
    public void test_get_Content(){
        String s = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .thenReturn()
                .asString();

        System.out.println( "Response Body : " + s);
        JsonPath json = new JsonPath(s);
        Assert.assertEquals(2, json.getInt("data.id"));
        Assert.assertEquals("janet.weaver@reqres.in", json.getString("data.email"));
        Assert.assertEquals("Janet", json.getString("data.first_name"));
        Assert.assertEquals("Weaver", json.getString("data.last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg", json.getString("data.avatar"));


    }

}
