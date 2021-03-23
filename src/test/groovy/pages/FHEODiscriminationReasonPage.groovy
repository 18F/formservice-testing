package pages

import geb.Page

class FHEODiscriminationReasonPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        respondentheader.text() == "Who discriminated against you?"

    }

     static content = {

         respondentheader(wait:true) {$("#eyc9oyh")}
         respondentFirstName(wait: true) { $("#ex7gihm-respondentFirstName") }
         respondentLastName(wait: true) { $("#e4rfx1k-respondentLastName") }
         respondentOrganization(wait: true) { $("#e53igtlh-respondentOrganization") }
         respondentPhoneNumber(wait: true) { $("#egc481-respondentPhoneNumber") }
         respondentEmail(wait: true) { $("#eugbek-respondentEmail") }
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