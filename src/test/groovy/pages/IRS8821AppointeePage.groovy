package pages

import geb.Page

class IRS8821AppointeePage extends Page {

         static at = { title == "GSA FormService"}

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


    void appointeeFirstName(String Appointee_firstName) {
        appointeeFirstName << Appointee_firstName
    }

    void appointeeLastName(String Appointee_lastName) {
        appointeeLastName << Appointee_lastName
    }

    void appointeePhoneNumber(String Appointee_phoneNumber) {
        appointeePhoneNumber << Appointee_phoneNumber
    }

    void appointeeMailingAddress(String Appointee_Address) {
        appointeeMailingAddress << Appointee_Address
    }

    void appointeeCity(String Appointee_City) {
        appointeeCity << Appointee_City
    }

    void appointeeState(String Appointee_State) {
        appointeeState << Appointee_State
    }

    void appointeeZip(String Appointee_Zip) {
        appointeeZip << Appointee_Zip
    }

    void appointeeCafNumber(String Appointee_CFANumber) {
        appointeeCafNumber << Appointee_CFANumber
    }

    void appointeePtin(String Appointee_PTIN) {
        appointeePtin << Appointee_PTIN
    }

    void appointeeFaxNumber(String Appointee_FAXNumber) {
        appointeeFaxNumber << Appointee_FAXNumber
    }

}