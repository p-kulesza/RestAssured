import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class RestfulAPITest {
    public static String base_url = "https://demoqa.com";

    @Test
    public void get_all_books(){
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET, "/BookStore/v1/Books");
        String contentType = response.header("Content-Type");

        Assert.assertEquals(contentType, "application/json; charset=utf-8");
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void get_specific_book(){
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET, "/BookStore/v1/Book");
        JSONObject requestParams = new JSONObject();

        request.header("isbn", "9781449337711");
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");

        String responsebody = response.getBody().asPrettyString();
        System.out.println(responsebody);
    }

    @Test
    public void gen_token(){
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("password", "password123");
        requestParams.put("userName", "newPerson");

        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString(1));

        Response response = request.request(Method.POST, "/Account/v1/GenerateToken");
        String responsebody = response.getBody().asPrettyString();
        System.out.println(responsebody);

        String statusBool = response.jsonPath().get("status");
        System.out.println(statusBool);

    }

//    public void
}
