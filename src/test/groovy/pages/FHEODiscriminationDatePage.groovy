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
        calenderBtn(wait: true) { $("i.fa.fa-calendar") }
        errMsg4(wait: true, required: false) { $("span[id\$=discriminationDate]") }

    }

    void discriminationDate(String date) {
        discriminationDate << date
    }

    boolean checkErrMsg4(String errMessage4) {
        if (errMessage4 != "") {
            waitFor {errMsg4.text() == errMessage4}
        }
        true
    }

}