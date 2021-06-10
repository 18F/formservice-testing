package pages

import geb.Page

class IRS8821AppointeePage extends Page {

         static at = { title == "Forms.gov - IRS 8821"}

        static content = {

            appointeeFirstName(wait: true) { $("input[id\$=appointeeFirstName]") }
            appointeeLastName(wait: true) { $("input[id\$=appointeeLastName]") }
            appointeePhoneNumber(wait: true) { $("input[id\$=appointeePhoneNumber]") }
            appointeeMailingAddress(wait: true) { $("input[id\$=appointeeMailingAddress]") }
            appointeeCity(wait: true) { $("input[id\$=appointeeCity]") }
            appointeeState(wait: true) { $("input[id\$=appointeeState]") }
            appointeeZip(wait: true) { $("input[id\$=appointeeZip]") }
            appointeeCafNumber(wait: true) { $("input[id\$=appointeeCafNumber]") }
            appointeePtin(wait: true) { $("input[id\$=appointeePtin]") }
            appointeeFaxNumber(wait: true) { $("input[id\$=appointeeFaxNumber]") }
            nextBtn(wait: true) { $("button[aria-label=\"Next button. Click to go to the next tab\"]") }
    }


    void Appointee_firstName(String Appointee_firstName) {
        appointeeFirstName << Appointee_firstName
    }

    void Appointee_lastName(String Appointee_lastName) {
        appointeeLastName << Appointee_lastName
    }

    void Appointee_phoneNumber(String Appointee_phoneNumber) {
        appointeePhoneNumber << Appointee_phoneNumber
    }

    void Appointee_Address(String Appointee_Address) {
        appointeeMailingAddress << Appointee_Address
    }

    void Appointee_City(String Appointee_City) {
        appointeeCity << Appointee_City
    }

    void Appointee_State(String Appointee_State) {
        appointeeState << Appointee_State
    }

    void Appointee_Zip(String Appointee_Zip) {
        appointeeZip << Appointee_Zip
    }

    void Appointee_CFANumber(String Appointee_CFANumber) {
        appointeeCafNumber << Appointee_CFANumber
    }

    void Appointee_PTIN(String Appointee_PTIN) {
        appointeePtin << Appointee_PTIN
    }

    void Appointee_FAXNumber(String Appointee_FAXNumber) {
        appointeeFaxNumber << Appointee_FAXNumber
    }

}