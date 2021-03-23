package pages

import geb.Page
import geb.module.RadioButtons
import geb.module.Select

class FHEODiscriminationHowToContactYouPage extends Page {

    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationContactHeader.text() == "How can we contact you?"

    }

    static content = {

        discriminationContactHeader(wait: true) { $("#emc6nt") }
        discriminationcomplainantFirstName(wait: true) { $("#ee63a-complainantFirstName") }
        discriminationcomplainantLastName(wait: true) { $("#ea4o768-complainantLastName") }
        discriminationcomplainantPhoneNumber(wait: true) { $("#egrm3y-complainantPhoneNumber") }
        discriminationcomplainantEmail(wait: true) { $("#e2ajsmd-complainantEmail") }
        discriminationcomplainantBestTimeToContactYouMorning(wait: true) { $("label[for='en3y2ms-morning']") }
        discriminationcomplainantBestTimeToContactYouAfternoon(wait: true) { $("label[for='en3y2ms-afternoon']") }
        discriminationcomplainantAddress(wait: true) { $("#e1hemzp-complainantAddress") }
        discriminationcomplainantAptSuiteUnit(wait: true) { $("#e01boom-complainantAptSuiteUnit") }
        discriminationcomplainantCity(wait: true) { $("#eotsvee-complainantCity") }

        discriminationcomplainantState(wait: true) { $("#eowqkq-complainantState") }

        discriminationcomplainantZip(wait: true) { $("#etdg5mc-complainantZip") }
        discriminationaltContactFirstName(wait: true) { $("#e2jmq0j-alternateContactFirstName") }
        discriminationaltContactLastName(wait: true) { $("#eyi5zfj-alternateContactLastName") }
        discriminationaltContactRelationshipFamilyOrFriend(wait: true) { $("label[for='eu5ksha-familyMemberOrFriend']") }
        discriminationaltContactRelationshipAttorneyOrLawyer(wait: true) { $("label[for='eu5ksha-attorneyOrLawyer']") }
        discriminationaltContactRelationshipFairHousingOrganization(wait: true) { $("label[for='eu5ksha-fairHousingOrganization']") }
        discriminationaltContactRelationshipOther(wait: true) { $("label[for='eu5ksha-other']") }
        discriminationaltOtherRelationshipDescription(wait: true) { $("#edb0ak7-alternativeContactOtherRelationshipDescription") }
        discriminationaltContactPhoneNumber(wait: true) { $("#euahelq-alternateContactPhoneNumber") }
        discriminationaltContactEmail(wait: true) { $("#elzn7bx-alternateContactEmail") }
        continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void discriminationcomplainantFirstName(String disccomplainantFirstName) {
        discriminationcomplainantFirstName = disccomplainantFirstName
    }

    void discriminationcomplainantLastName(String disccomplainantLastName) {
        discriminationcomplainantLastName = disccomplainantLastName
    }

    void discriminationcomplainantPhoneNumber(String disccomplainantPhoneNumber) {
        discriminationcomplainantPhoneNumber = disccomplainantPhoneNumber
    }

    void discriminationcomplainantEmail(String disccomplainantEmail) {
        discriminationcomplainantEmail =(""!= disccomplainantEmail)?disccomplainantEmail:""

    }

    void discriminationcomplainantBestTimeToContactYou(String disccomplainantBestTimeToContactYou) {
        if ("morning".equalsIgnoreCase(disccomplainantBestTimeToContactYou)) {
            discriminationcomplainantBestTimeToContactYouMorning.click()
        } else if ("afternoon".equalsIgnoreCase(disccomplainantBestTimeToContactYou)) {
            discriminationcomplainantBestTimeToContactYouAfternoon.click()
        }
    }

    void discriminationcomplainantAddress(String disccomplainantAddress) {
        discriminationcomplainantAddress = disccomplainantAddress
    }

    void discriminationcomplainantAptSuiteUnit(String disccomplainantAptSuiteUnit) {
        discriminationcomplainantAptSuiteUnit =(""!=disccomplainantAptSuiteUnit)?disccomplainantAptSuiteUnit:""

    }

    void discriminationcomplainantCity(String disccomplainantCity) {
        discriminationcomplainantCity = disccomplainantCity
    }

    void discriminationcomplainantState(String disccomplainantState) {
        discriminationcomplainantState.module(Select).selected = disccomplainantState
    }

    void discriminationcomplainantZip(String disccomplainantZip) {
        discriminationcomplainantZip = disccomplainantZip
    }

    void discriminationaltContactFirstName(String discaltContactFirstName) {
        discriminationaltContactFirstName =(""!= discaltContactFirstName)?discaltContactFirstName:""

    }

    void discriminationaltContactLastName(String discaltContactLastName) {
        discriminationaltContactLastName =(""!= discaltContactLastName)?discaltContactLastName:""
    }

    void discriminationaltContactRelationship(String discaltContactRelationship, String discriminationaltOtherRelationshipDesc) {
        if ("Family member or friend".equalsIgnoreCase(discaltContactRelationship)) {
            discriminationaltContactRelationshipFamilyOrFriend.click()
        } else if ("Attorney or lawyer".equalsIgnoreCase(discaltContactRelationship)) {
            discriminationaltContactRelationshipAttorneyOrLawyer.click()
        } else if ("Fair housing organization".equalsIgnoreCase(discaltContactRelationship)) {
            discriminationaltContactRelationshipFairHousingOrganization.click()
        } else if ("Other".equalsIgnoreCase(discaltContactRelationship)) {
            discriminationaltContactRelationshipOther.click()
            discriminationaltOtherRelationshipDescription = discriminationaltOtherRelationshipDesc
        }
    }



    void discriminationaltContactPhoneNumber(String discaltContactPhoneNumber) {
        discriminationaltContactPhoneNumber =(""!= discaltContactPhoneNumber)?discaltContactPhoneNumber:""
    }

    void discriminationaltContactEmail(String discaltContactPhoneNumber) {
        discriminationaltContactEmail = discaltContactPhoneNumber
    }

}