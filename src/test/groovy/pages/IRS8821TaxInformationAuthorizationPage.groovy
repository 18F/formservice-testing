package pages

import geb.Page

class IRS8821TaxInformationAuthorizationPage extends Page {

         static at = { title == "GSA FormService"}

        static content = {

            nextBtn(wait: true) { $("button[aria-label=\"Next button. Click to go to the next tab\"]") }
    }


}