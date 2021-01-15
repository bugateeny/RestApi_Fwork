package restAssuredQuickTest;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;


public class post_Schedule {


    @Test
    // ADD SCHEDULE
    public void post_Schedules() {

        RestAssured.baseURI = "http://be-c8vix-qa:54030";
        String response = given().log().all() //log().all() is for print all
                .header("Content-Type", "application/json")
                .contentType("application/json;charset=UTF-8")
//  Body from post
                .body(payload.AddSchedules())
                .when()
                .post("api.vixen/workschedules")
// Assertions
                .then().assertThat().statusCode(201).body("workSchedules.shortDescription", hasItems("Adey"))
                .header("X-Application-Context", "application:54030")

                //Extract the response body and allocate to a variable name (response )
                .extract().response().asString();

        //System.out.println(response);

        JsonPath js = new JsonPath(response);  // For parsing Json and stores in js
        String workSheduleId = js.getString("workSchedules.workScheduleId");  //  Place workSheduleCode in workSheduleCode variable

        System.out.println("workSheduleId here: " + workSheduleId);  //  Remember to concatinate workSheduleId in PUT body

//UPDATE SCHEDULE
        String updateResponse = given().log().all() //log().all() is for print all

                .queryParam("id",workSheduleId)
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

        System.out.println(updateResponse);
    }
}