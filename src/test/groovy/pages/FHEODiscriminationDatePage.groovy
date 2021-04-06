package pages

import geb.Page
import geb.module.Select

class FHEODiscriminationDatePage extends Page {


    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationdateHeader.text() == "When did the discrimination happen?"

    }

    static content = {

        discriminationdateHeader(wait: true) { $("div > h2") }
        discriminationDate(wait: true) { $("[placeholder='MM-dd-yyyy'][tabIndex='0']") }
        monthDropdown(wait: true) { $(".flatpickr-monthDropdown-months") }
        continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void discriminationDate(String date) {
        discriminationDate << date
    }

}