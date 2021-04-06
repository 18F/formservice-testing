package pages

import geb.Page

class FHEODiscriminationConfirmationPage extends Page {


    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationConfirmationHeader.text() == "Your complaint was successfully submitted"

    }

    static content = {

        discriminationConfirmationHeader(wait: true) { $(".usa-alert__heading") }


    }


}