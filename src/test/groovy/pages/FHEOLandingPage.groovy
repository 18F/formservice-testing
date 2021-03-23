package pages

import geb.Page

class FHEOLandingPage extends Page {

        static at = { title == "HUD Housing Discrimination Complaint" }

        static content = {

        submitmyComplaintBtn(wait: true) { $("div > button.usa-button") }

    }

}