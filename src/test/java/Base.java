import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class Base {

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://api.paystack.co/page";
        RestAssured.authentication = RestAssured.oauth2("sk_test_617123c2db5924079bd6fda54dfcaa5c86f6b6a5");
    }
}
