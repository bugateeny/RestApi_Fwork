package restAssuredQuickTest;


import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class test_Get {
    @Test
//    public void restAssuredGetRequest() {
// Get  Engineers - Adey
//        given()
//                .when()
//                .get("http://be-c8vix-qa:54030/api.vixen/engineers/ids/?ids=01/01")
//                .then().statusCode(200)
//                .contentType("application/json;charset=UTF-8")
//                .body("engineers.engineerId[0]", is("01/01"))
//                .body("engineers.company[0]", is("01"))
//                .body("engineers.engineerName[0]", anything("Adey"))
//                .body("engineers.resourceGroup[0]", is("RESPONSIVE")).log().all();
//    }

    public void restAssuredGetRequest2() {
// Get list of engineers and find this names
                given()
                .when()
                .get("http://be-c8vix-qa:54030/api.vixen/engineers")
                .then()
                .statusCode(200)
                .contentType("application/json;charset=UTF-8")
                .statusCode(200)
                .body("engineers.engineerName", hasItems("Barry Red", "Anchor Unallocated")).log().all();

    }


}