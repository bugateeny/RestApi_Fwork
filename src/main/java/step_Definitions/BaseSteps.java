package step_Definitions;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import com.jayway.jsonpath.DocumentContext;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSteps {

    //Service
    public String serviceUrl;

    //Job Callout
    public String MakeAJobInterfacePayload, MakeAJobEventPayload,MakeAJobNoInterfacePayload;
    public String make_A_Job_ID_Interface_Endpoint, make_A_Job_With_InterfaceEndpoint, makeAJob_No_InterfaceEndpoint, makeAJobEventEndpoint;

    // Purchase Ledger
    public String Make_A_PL_Payload;
    public String make_A_PL_Account;


    public Headers headers;
    private String endpointPath;
    private Response response;
    public DocumentContext requestBodyJson;


    public BaseSteps(){
        serviceUrl = "http://192.168.132.176:54040/api.vixen/";

        MakeAJobInterfacePayload = "/templates/CreateAJobWithInterface.jso";
        MakeAJobNoInterfacePayload = "/templates/CreateAJobNoInterface.jso";
        MakeAJobEventPayload = "/templates/CreateAJobsEvent.jso";

        make_A_Job_ID_Interface_Endpoint = serviceUrl + "jobs/id/" ;
        make_A_Job_With_InterfaceEndpoint = serviceUrl + "jobs/reactive/"; // Interface tag in body request "interfaceJob": "true"  makes it different to other POST
        makeAJob_No_InterfaceEndpoint = serviceUrl + "jobs/reactive/"; // No Interface -  Call gets created as normal
        makeAJobEventEndpoint = serviceUrl + "jobevents/clients/id/01ADE001+?interfaceJobsOnly=true&deleteLater=false/"; //   Create a job event

        //PL
        Make_A_PL_Payload= "/templates/Create_A_PL_Account.j";
        make_A_PL_Account= serviceUrl + "suppliers/";

    }

    public void setHeaders(Headers value){
        restHeaders();
        headers = value;
    }

    private void restHeaders() {
        headers = null;
    }

    public void setHeadersWithContentType(){
        headers = new Headers(
                new Header("Content-Type", "application/json"));
        setHeaders(headers);
    }

    //    public void setHeadersWithManyHeaders(){
//        headers = new Headers(
//                new Header("Content-Type", "application/json"),
//                new Header("Authorisation", "89289789jkjkhjkhu9njnknkjh98"),
//                new Header("Token", "token Value"));
//        setHeaders(headers);
//    }
    protected URL getURL(){
        try {
            return new URL(endpointPath);
        } catch(MalformedURLException e){
            throw new RuntimeException();
        }
    }
    public Response getRequest(){
        response = RestAssured.given()
                .log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(getURL())
                .then()
                .log().all()
                .extract()
                .response();
        return response;
    }
    public Response getPost(){
        response = RestAssured.given()
                .log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(requestBodyJson.jsonString())
                .when()
                .post(getURL())
                .then()
                .log().all()
                .extract()
                .response();
        return response;
    }
    public Response getPut(){
        response = RestAssured.given()
                .log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(requestBodyJson.jsonString())
                .when()
                .put(getURL())
                .then()
                .log().all()
                .extract()
                .response();
        return response;
    }
    public Response getDelet(){
        response = RestAssured.given()
                .log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(requestBodyJson.jsonString())
                .when()
                .delete(getURL())
                .then()
                .log().all()
                .extract()
                .response();
        return response;
    }
    public void setEndpointPath(String endpointPath){
        this.endpointPath = endpointPath;
    }
    public Response getResponse(){
        return response;
    }
//    public void setRequestBody(DocumentContext requestBody){
//        this.requestBodyJson= requestBody;
//}
    public DocumentContext loadJsonTemplate(String path){
        requestBodyJson = JsonPath.parse(this.getClass().getResourceAsStream(path));
        return requestBodyJson;
    }


}
