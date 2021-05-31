package pages

import geb.Page

class IRS8821SubmitTaxInformationPage extends Page {

         static at = { title == "GSA FormService"}

        static content = {
            authBtn(wait: true) { $(".input.usa-checkbox__input") }
            submitformBtn(wait: true) { $("button[aria-label=\"Submit Form button. Click to submit the form\"]") }
    }

}