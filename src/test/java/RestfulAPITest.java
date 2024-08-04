import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestfulAPITest {
    private static final String BASE_URL = "https://reqres.in/api";


    @Test
    public void get_users(){
       Response response = RestAssured.get("https://reqres.in/api/users");
        String body = response.getBody().asString();
        System.out.println(body);

    }
}
