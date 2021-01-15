package restAssuredQuickTest;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class test_Post {
    @Test
    public void test_1_post() {
        RestAssured.baseURI = "http://be-c8vix-qa:54030";

        given().log().all() //log().all() is for print all

                .queryParam("key","adey123")
                .header("Content-Type", "application/json")
                .body("     {\n" +
                        "    \"company\": \"01\",\n" +
                        "    \"shortDescription\": \"YES\",\n" +
                        "    \"scheduleLine1\": \"Wolves 77\",\n" +
                        "    \"scheduleLine2\": \"Wolves 77\",\n" +
                        "    \"workScheduleCode\": \"05-20    A\",\n" +
                        "    \"workScheduleId\": \"0105-20    A\"\n" +
                        "  }\n" +
                        "\n")

                .when().put("api.vixen/workschedules/id")
                .then().assertThat().log().all().statusCode(201).header("x-application-context", "application:54030").extract().asString();



    }
}
