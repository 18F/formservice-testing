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

    }

    void discriminationDescription(String discDescription) {
        discriminationDescription = discDescription
    }

}