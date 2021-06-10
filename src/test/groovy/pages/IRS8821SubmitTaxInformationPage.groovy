package pages

import geb.Page

class IRS8821SubmitTaxInformationPage extends Page {

         static at = { title == "Forms.gov - IRS 8821"}

        static content = {
            authBtn(wait: true) { $("label[for\$='taxInformationAuthorizeAccess'].usa-checkbox__label") }
            submitformBtn(wait: true) { $("button[aria-label='Submit Form button. Click to submit the form']") }
    }

}