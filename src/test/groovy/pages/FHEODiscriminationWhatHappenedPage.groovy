package pages

import geb.Page

class FHEODiscriminationWhatHappenedPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        discriminationDesHeader.text() == "What happened?"

    }

     static content = {

         discriminationDesHeader(wait:true) {$("div > h2")}
         discriminationDescription(wait:true) {$("textarea[id\$=discriminationDescription]")}
         continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }
         errMsg5(wait: true, required: false) { $("span[id\$=discriminationDescription") }

    }

    void discriminationDescription(String discDescription) {
        discriminationDescription = discDescription
    }

    boolean checkErrMsg5(String errMessage5) {
        if (errMessage5 != "") {
            waitFor {errMsg5.text() == errMessage5}
        }
        true
    }

}