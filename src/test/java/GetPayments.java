import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
public class GetPayments extends Base {

    @Test
    public void getAllPayments() {

        RestAssured
                .given()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.id", hasItem(id));
    }

}
