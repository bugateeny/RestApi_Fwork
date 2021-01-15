package doddsApi;

import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class jobCallOut {
   @Test
    public void get_JobEvents() {

        //http://192.168.132.176:54040/api.vixen/swagger-ui.html
        given().contentType(ContentType.JSON)
                .when()
                .get("http://192.168.132.176:54040/api.vixen/jobevents/")
                .then()
                .statusCode(200)
                .log().all();
    }
    //@Test
    public void post_CallOut() {
        HashMap<String, String> postPayLoad = new HashMap<>();

        postPayLoad.put("companyNumber", "01");
        postPayLoad.put("contact", "Adey Sogbesan");
        postPayLoad.put("contract", "100140");
        postPayLoad.put("uprn", "DODDS-REF");
        postPayLoad.put("contractCode", "");
        postPayLoad.put("orderNumber", "DODDS00");
        postPayLoad.put("priority", "2");
        postPayLoad.put("description", "Demo Text");
        postPayLoad.put("interfaceJob", "true");
        postPayLoad.put("siteAccount", "");
        postPayLoad.put("comment1", "First Test");
        postPayLoad.put("comment2", "First Test");
        postPayLoad.put("jobText", "Job Description as First Test");
        postPayLoad.put("telephoneNumber", "07876545541");

        given().contentType(ContentType.JSON)
                .with()
                .body(postPayLoad).log().all()
                .when()
                .post("http://192.168.132.176:54040/api.vixen/jobs/reactive")
                .then()
                .statusCode(201)
                .body("body[0].companyNumber", containsStringIgnoringCase("01"))
                .body("body[0].orderNumber", containsStringIgnoringCase("DODDS00"))
                .body("body[0].siteAccount", containsStringIgnoringCase("ADE001"))
                .body("statusCode[0]", containsStringIgnoringCase("OK"))
                .log().all();
    }

    public void post_EventCode() {

        HashMap<String, String> eventPayLoad = new HashMap<>();

        eventPayLoad.put("events", "500");

        given().contentType(ContentType.JSON)
                .with()
                .body(eventPayLoad)
                .when()
                .post("http://192.168.132.176:54040/api.vixen/jobevents/clients/id/01ADE001?interfaceJobsOnly=true&deleteLater=false")
                .then()
                .statusCode(200)
                .body("body[0].companyNumber", containsStringIgnoringCase("01"))
                .body("body[0].orderNumber", containsStringIgnoringCase("DODDS00"))
                .body("body[0].siteAccount", containsStringIgnoringCase("ADE001"));
    }
}
