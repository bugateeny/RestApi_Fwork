package step_Definitions;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyServices;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Purchase_Ledger_Api extends BaseSteps {

    Response resForPostedPlAccount;
    DocumentContext requestBody;

    @When("I enter all the essential elements to create PL account load, like {string},{string},{string},{string},{string}, if it is a subcontractor include the follow {string}, {string}")
    public void iEnterAllTheEssentialElementsToCreatePLAccountLoadLikeIfItIsASubcontractorIncludeTheFollow
                                                                                (String companyNumber, String suppliersId,
                                                                                 String name, String address,
                                                                                 String sortKey, String subcontractor,
                                                                                 String subconVatNumber)
    {
        RequestBodyServices request_PL_BodyServices = new RequestBodyServices();
        requestBody = loadJsonTemplate(Make_A_PL_Payload);
        request_PL_BodyServices.set_PL_RequestBody
                                                                                (requestBody, companyNumber,
                                                                                suppliersId, name, address, sortKey,
                                                                                subcontractor, subconVatNumber);

        setHeadersWithContentType();
        setEndpointPath(make_A_PL_Account);
        getPost();
        resForPostedPlAccount = getResponse();

    }

    @Then("Then I should validate {string} and status code returns {int}")
    public void then_i_should_validate_and_status_code_returns(String suppliersId, int sCode) {
        assertThat(resForPostedPlAccount.statusCode(), is(sCode));
        assertThat(resForPostedPlAccount.body().jsonPath().get("suppliers[0].suppliersId").toString(), is(suppliersId));
    }

}
