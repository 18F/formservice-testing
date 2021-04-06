package pages

import geb.Page

class FHEODiscriminationReviewAndSubmitPage extends Page {


    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationReviewandSubmitHeader.text() == "Review and submit your complaint"

    }

    static content = {

        discriminationReviewandSubmitHeader(wait: true) { $("div > h2") }
        submitBtn(wait: true) { $("button[aria-label=\"SUBMIT MY COMPLAINT button. Click to submit the form\"]") }

    }


}