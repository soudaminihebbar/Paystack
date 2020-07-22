import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import java.io.File;

public class CreatePage extends Base {
    File file = new File("pageData.json");

    @Test
    public void createPage() {

        ExtractableResponse response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(file)
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract();
        id = response.jsonPath().get("data.id");
        name = response.jsonPath().get("data.name");
    }


}
