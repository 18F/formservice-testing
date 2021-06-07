package pages

import geb.Page

class IRS8821TaxpayerInformationPage extends Page {

    static at = { title == "Forms.gov - IRS 8831"}

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

    void Taxpayer_firstName(String Taxpayer_firstName) {
        TaxPayerFirstName << Taxpayer_firstName
    }

    void Taxpayer_lastName(String Taxpayer_lastName) {
        TaxPayerLastName<< Taxpayer_lastName
    }

    void Taxpayer_PhoneNumber(String Taxpayer_PhoneNumber) {
        TaxPayerPhoneNumber << Taxpayer_PhoneNumber
    }

    void Taxpayer_HomeAddress(String Taxpayer_HomeAddress) {
        TaxPayerAddress << Taxpayer_HomeAddress
    }

    void Taxpayer_City(String Taxpayer_City) {
        TaxPayerCity << Taxpayer_City
    }

    void Taxpayer_State(String Taxpayer_State) {
        TaxPayerState << Taxpayer_State
    }

    void Taxpayer_Zipcode(String Taxpayer_Zipcode) {
        TaxPayerZip << Taxpayer_Zipcode
    }

    void Taxpayer_IdentityNumber(String Taxpayer_IdentityNumber) {
        TaxPayerIDNumber << Taxpayer_IdentityNumber
    }

    void Taxpayer_planNumber(String Taxpayer_planNumber) {
        TaxPayerPlanNumber << Taxpayer_planNumber
    }

}