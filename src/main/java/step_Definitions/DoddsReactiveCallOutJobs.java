package step_Definitions;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyServices;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DoddsReactiveCallOutJobs extends BaseSteps {

    Response responseForGetService,responseForGetJobId, resForPostedReactiveJobInterface;
    DocumentContext requestBody;

    @Given("Service is up and running")
    public void service_is_up_and_running() {
        setHeadersWithContentType();
        setEndpointPath(serviceUrl);
        getRequest();
        responseForGetService = getResponse();
        assertThat(responseForGetService.statusCode(), is(200));

    }

    @When("I search for a {string} with GET method")
    public void i_search_for_a_job(String jobId) {
        setHeadersWithContentType();
        setEndpointPath(make_A_Job_ID_Interface_Endpoint + jobId);
        getRequest();
        responseForGetJobId = getResponse();
        assertThat(responseForGetJobId.body().jsonPath().get("jobId").toString(), is (jobId));

    }

    @Then("Then I should get correct {string}, {string} and {string} returned with status code of {int}")
    public void theIShouldGetCorrectAndReturnedWithStatusCodeOf(String jobNo, String siteAccount, String orderNumber, int sCode) {

        assertThat(responseForGetJobId.statusCode(), is(sCode));
        assertThat(responseForGetJobId.body().jsonPath().get("contract").toString().contains("100140"), is (true)); //  Have hard coded the expected data value here with using Gherkin
        assertThat(responseForGetJobId.body().jsonPath().get("jobNo").toString(), is (jobNo));
        assertThat(responseForGetJobId.body().jsonPath().get("siteAccount").toString(), is (siteAccount));
        assertThat(responseForGetJobId.body().jsonPath().get("orderNumber").toString(), is (orderNumber));

    }

//POST REQUEST - JOB REACTIVE CALL_OUT "<companyNumber>","<contact>","<description>","<uprn>","<orderNumber>","<priority>"  "<siteAccount>","<jobNo>" and "<jobId>"
    @When("I create a new API job call-out with the following mandatory fields {string},{string},{string},{string},{string},{string} and {string} with POST method")
    public void iCreateANewAPIJobCallOutWithTheFollowingMandatoryFieldsWithPOSTMethod(String companyNumber, String contact, String description, String uprn, String orderNumber, String priority,  String interfaceJob)
    {

        RequestBodyServices requestBodyServices = new RequestBodyServices();
        requestBody = loadJsonTemplate(MakeAJobInterfacePayload);
        requestBodyServices.setRequestBodyForReactiveInterface(requestBody, companyNumber, contact, description, uprn, orderNumber, priority, interfaceJob);

        setHeadersWithContentType();
        setEndpointPath(make_A_Job_With_InterfaceEndpoint);
        getPost();
        resForPostedReactiveJobInterface = getResponse();

    }
//Asserts
    @Then("Then I should validate correct {string},{string} and {string} returned with job created status code of {int}")
    public void thenIShouldValidateCorrectAndReturnedWithJobCreatedStatusCodeOf(String siteAccount, String jobNo, String jobId, int sCode) {

        assertThat(resForPostedReactiveJobInterface.statusCode(), is(sCode));
        assertThat(resForPostedReactiveJobInterface.body().jsonPath().get("body[0].siteAccount").toString(), is (siteAccount));
        assertThat(resForPostedReactiveJobInterface.body().jsonPath().get("body[0].jobNo").toString(), is (jobNo));
        assertThat(resForPostedReactiveJobInterface.body().jsonPath().get("body[0].jobId").toString().contains(jobId ), is (true));
    }


}

