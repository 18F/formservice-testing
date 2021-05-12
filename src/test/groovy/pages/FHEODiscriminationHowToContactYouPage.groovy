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

        discriminationContactHeader(wait: true) { $("div > h2") }
        discriminationcomplainantFirstName(wait: true) { $("input[id\$=complainantFirstName]") }
        discriminationcomplainantLastName(wait: true) { $("input[id\$=complainantLastName]") }
        discriminationcomplainantPhoneNumber(wait: true) { $("input[id\$=complainantPhoneNumber]") }
        discriminationcomplainantEmail(wait: true) { $("input[id\$=complainantEmail]") }
        discriminationcomplainantBestTimeToContactYouMorning(wait: true) { $("label[for\$=morning]") }
        discriminationcomplainantBestTimeToContactYouAfternoon(wait: true) { $("label[for\$=afternoon]") }
        discriminationcomplainantAddress(wait: true) { $("input[id\$=complainantAddress]") }
        discriminationcomplainantAptSuiteUnit(wait: true) { $("input[id\$=complainantAptSuiteUnit]") }
        discriminationcomplainantCity(wait: true) { $("input[id\$=complainantCity]") }

        discriminationcomplainantState(wait: true) { $("select[id\$=complainantState]") }

        discriminationcomplainantZip(wait: true) { $("input[id\$=complainantZip]") }
        discriminationaltContactFirstName(wait: true) { $("input[id\$=alternateContactFirstName]") }
        discriminationaltContactLastName(wait: true) { $("input[id\$=alternateContactLastName]") }
        discriminationaltContactRelationshipFamilyOrFriend(wait: true) { $("label[for\$=familyMemberOrFriend]") }
        discriminationaltContactRelationshipAttorneyOrLawyer(wait: true) { $("label[for\$=attorneyOrLawyer]") }
        discriminationaltContactRelationshipFairHousingOrganization(wait: true) { $("label[for\$=fairHousingOrganization]") }
        discriminationaltContactRelationshipOther(wait: true) { $("label[for\$=other]") }
        discriminationaltOtherRelationshipDescription(wait: true) { $("input[id\$=alternativeContactOtherRelationshipDescription]") }
        discriminationaltContactPhoneNumber(wait: true) { $("input[id\$=alternateContactPhoneNumber]") }
        discriminationaltContactEmail(wait: true) { $("input[id\$=alternateContactEmail]") }
        errMsg6(wait: true, required: false) { $("span[id\$=complainantFirstName]") }
        errMsg7(wait: true, required: false) { $("span[id\$=complainantLastName]") }
        errMsg8(wait: true, required: false) { $("span[id\$=complainantPhoneNumber]") }
        errMsg9(wait: true, required: false) { $("span[id\$=complainantAddress]") }
        errMsg10(wait: true, required: false) { $("span[id\$=complainantCity]") }
        errMsg11(wait: true, required: false) { $("span[id\$=complainantState]") }
        errMsg12(wait: true, required: false) { $("span[id\$=complainantZip]") }
        continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void discriminationcomplainantFirstName(String disccomplainantFirstName) {
        discriminationcomplainantFirstName = disccomplainantFirstName
    }

    void discriminationcomplainantLastName(String disccomplainantLastName) {
        discriminationcomplainantLastName = disccomplainantLastName
    }

    void discriminationcomplainantPhoneNumber(String disccomplainantPhoneNumber) {
        if (System.getProperty("device") == null)
        {
            discriminationcomplainantPhoneNumber = disccomplainantPhoneNumber
        }
        else if (System.getProperty("device") != null)
        {
            disccomplainantPhoneNumber.each { it ->
                discriminationcomplainantPhoneNumber << it
            }
        }
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
        if (System.getProperty("device") == null)
        {
            discriminationcomplainantZip = disccomplainantZip
        }
        else if (System.getProperty("device") != null)
        {
            disccomplainantZip.each { it ->
                discriminationcomplainantZip << it
            }
        }
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
        if (System.getProperty("device") == null)
        {
            discriminationaltContactPhoneNumber =(""!= discaltContactPhoneNumber)?discaltContactPhoneNumber:""
        }
        else if (System.getProperty("device") != null)
        {
            discaltContactPhoneNumber.each { it ->
                discriminationaltContactPhoneNumber << it
            }
        }
    }


    void discriminationaltContactEmail(String discaltContactEmail) {
        discriminationaltContactEmail = discaltContactEmail
    }

    boolean checkErrMsg6(String errMessage6) {
        if (errMessage6 != "") {
            waitFor {errMsg6.text() == errMessage6}
        }
    }

    boolean checkErrMsg7(String errMessage7) {
        if (errMessage7 != "") {
            waitFor {errMsg7.text() == errMessage7}
        }
    }

    boolean checkErrMsg8(String errMessage8) {
        if (errMessage8 != "") {
            waitFor {errMsg8.text() == errMessage8}
        }
    }

    boolean checkErrMsg9(String errMessage9) {
        if (errMessage9 != "") {
            waitFor {errMsg9.text() == errMessage9}
        }
    }

    boolean checkErrMsg10(String errMessage10) {
        if (errMessage10 != "") {
            waitFor {errMsg10.text() == errMessage10}
        }
    }

    boolean checkErrMsg11(String errMessage11) {
        if (errMessage11 != "") {
            waitFor {errMsg11.text() == errMessage11}
        }
    }

    boolean checkErrMsg12(String errMessage12) {
        if (errMessage12 != "") {
            waitFor {errMsg12.text() == errMessage12}
        }
    }


}