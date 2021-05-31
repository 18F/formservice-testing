package pages

import geb.Page

class IRS8821TaxpayerInformationPage extends Page {

    static at = { title == "GSA FormService"}

    static content = {

        TaxPayerFirstName(wait: true) { $("input[id\$=taxpayerFirstName]") }
        TaxPayerLastName(wait: true) { $("input[id\$=taxpayerLastName]") }
        TaxPayerPhoneNumber(wait: true) { $("input[id\$=taxpayerDaytimePhoneNumber]") }
        TaxPayerAddress(wait: true) { $("input[id\$=taxpayerHomeAddress]") }
        TaxPayerCity(wait: true) { $("input[id\$=taxpayerCity]") }
        TaxPayerState(wait: true) { $("input[id\$=taxpayerState]") }
        TaxPayerZip(wait: true) { $("input[id\$=taxpayerZip]") }
        TaxPayerIDNumber(wait: true) { $("input[id\$=taxpayerIdentificationNumber]") }
        TaxPayerPlanNumber(wait: true) { $("input[id\$=taxpayerPlanNumber]") }
        nextBtn(wait: true) { $("button[aria-label=\"Next button. Click to go to the next tab\"]") }
    }

    void TaxPayerFirstName(String Taxpayer_firstName) {
        TaxPayerFirstName << Taxpayer_firstName
    }

    void TaxPayerLastName(String Taxpayer_lastName) {
        TaxPayerLastName<< Taxpayer_lastName
    }

    void TaxPayerPhoneNumber(String Taxpayer_PhoneNumber) {
        TaxPayerPhoneNumber << Taxpayer_PhoneNumber
    }

    void TaxPayerAddress(String Taxpayer_HomeAddress) {
        TaxPayerAddress << Taxpayer_HomeAddress
    }

    void TaxPayerCity(String Taxpayer_City) {
        TaxPayerCity << Taxpayer_City
    }

    void TaxPayerState(String Taxpayer_State) {
        TaxPayerState << Taxpayer_State
    }

    void TaxPayerZip(String Taxpayer_Zipcode) {
        TaxPayerZip << Taxpayer_Zipcode
    }

    void TaxPayerIDNumber(String Taxpayer_IdentityNumber) {
        TaxPayerIDNumber << Taxpayer_IdentityNumber
    }

    void TaxPayerPlanNumber(String Taxpayer_planNumber) {
        TaxPayerPlanNumber << Taxpayer_planNumber
    }

}