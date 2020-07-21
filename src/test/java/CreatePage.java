import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class CreatePage extends Base{
    File file = new File("pageData.json");
    @Test
    public void createPage() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(file)
                .post()
                .then()
                .assertThat()
                .statusCode(200);

    }


}
