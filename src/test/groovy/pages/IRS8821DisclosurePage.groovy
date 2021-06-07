package pages

import geb.Page

class IRS8821DisclosurePage extends Page {

         static at = { title == "Forms.gov - IRS 8831"}

        static content = {

            Disclosureoption(wait: true) { $("label[for\$='disclosureAppointeeCommunicationsSent'].usa-checkbox__label") }
            nextBtn(wait: true) { $("button[aria-label=\"Next button. Click to go to the next tab\"]") }

    }

}