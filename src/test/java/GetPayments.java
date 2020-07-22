import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

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

    @Test
    public void getPaymentAndVerifyDetails() {

        ExtractableResponse response = RestAssured
                .given()
                .get(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.name", equalTo(name))
                .extract();
        int latestId = response.jsonPath().get("data.id");
        assertThat(latestId).isEqualTo(id);
    }

}
