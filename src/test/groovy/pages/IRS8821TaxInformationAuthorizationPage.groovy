package pages

import geb.Page

class IRS8821TaxInformationAuthorizationPage extends Page {

         static at = { title == "Forms.gov - IRS 8831"}

        static content = {

            nextBtn(wait: true) { $("button[aria-label=\"Next button. Click to go to the next tab\"]") }
    }


}