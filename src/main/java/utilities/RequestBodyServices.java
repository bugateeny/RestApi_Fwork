package utilities;

import com.jayway.jsonpath.DocumentContext;

public class RequestBodyServices {
    // 6 Mandatory Body request ( Acceptance Criteria )
    public void setRequestBodyForReactiveInterface(DocumentContext requestBody, String companyNumber,
                                                   String contact, String description,
                                                   String uprn, String orderNumber, String priority, String interfaceJob) {
        //  Added extra request body if required
        requestBody.set("companyNumber", companyNumber);
        requestBody.set("contact", contact);

        requestBody.set("contractCode", "");
        requestBody.set("orderNumber", orderNumber);
        requestBody.set("priority", priority);
        requestBody.set("description", description);
        requestBody.set("interfaceJob", interfaceJob);

        //      requestBody.set("contract", 100140);
//      requestBody.set("uprn", "DODDS-REF");
//      requestBody.set("siteAccount", "");
//      requestBody.set("comment1", "First Test");
//      requestBody.set("comment2", "First Test");
//      requestBody.set("jobText", "Job Description as First Test");
//      requestBody.set("telephoneNumber", "07876545541");
    }

    public void setRequestBodyForReactiveWithouthInterface(DocumentContext requestBody, String companyNumber,
                                                           String contact, String description,
                                                           String uprn, String orderNumber, String priority) {
        requestBody.set("companyNumber", companyNumber);
        requestBody.set("contact", contact);
        requestBody.set("uprn", uprn);
        requestBody.set("contractCode", "");
        requestBody.set("orderNumber", orderNumber);
        requestBody.set("priority", priority);
        requestBody.set("description", description);
//        requestBody.set("contract", contract);
//        requestBody.set("siteAccount", "");
//        requestBody.set("comment1", "First Test");
//        requestBody.set("comment2", "First Test");
//        requestBody.set("jobText", "Job Description as First Test");
//        requestBody.set("telephoneNumber", "07876545541");
    }


    public void setRequestBodyForJobEvent(DocumentContext requestBody, String events) {
        requestBody.set("events", events);
//        requestBody.set("events", "700");
    }


    // Purchase Ledger
    public void set_PL_RequestBody(DocumentContext requestBody, String companyNumber,
                                   String suppliersId, String name, String address,
                                   String sortKey, String subcontractor, String subconVatNumber) {
        requestBody.set("companyNumber", companyNumber);
        requestBody.set("suppliersId", suppliersId);
        requestBody.set("name", name);
        requestBody.set("address", address);
        requestBody.set("sortKey", sortKey);
        requestBody.set("subcontractor", subcontractor);
        requestBody.set("subconVatNumber", subconVatNumber);
    }



}
