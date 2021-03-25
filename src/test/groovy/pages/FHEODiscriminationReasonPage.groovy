package pages

import geb.Page

class FHEODiscriminationReasonPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        respondentheader.text() == "Who discriminated against you?"

    }

     static content = {

         respondentheader(wait:true) {$("div > h2")}
         respondentFirstName(wait: true) { $("input[id\$=respondentFirstName]") }
         respondentLastName(wait: true) { $("input[id\$=respondentLastName") }
         respondentOrganization(wait: true) { $("input[id\$=respondentOrganization") }
         respondentPhoneNumber(wait: true) { $("input[id\$=respondentPhoneNumber") }
         respondentEmail(wait: true) { $("input[id\$=respondentEmail") }
         continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void enterrespondentFirstName(String respFirstName) {
           respondentFirstName=(""!= respFirstName)?respFirstName:""
    }

    void enterrespondentLastName(String respLastName) {
            respondentLastName =(""!= respLastName)?respLastName:""
    }

    void enterrespondentOrganization(String respOrganization) {
            respondentOrganization =(""!= respOrganization)?respOrganization:""
    }

    void enterrespondentPhoneNumber(String respPhoneNumber) {
            respondentPhoneNumber =(""!=respPhoneNumber)?respPhoneNumber:""
    }

    void enterrespondentEmail(String respEmail) {
            respondentEmail =(""!=respEmail)?respEmail:""
    }

}