import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestTest {
    @Test
    public void test_1(){
        Response response = RestAssured.get("https://mvnrepository.com/");
        int statusCode = response.getStatusCode();
        long responseTime = response.getTime();
        System.out.println("Status code is: " + statusCode);
        System.out.println("Response time is: " + responseTime);
    }
}
