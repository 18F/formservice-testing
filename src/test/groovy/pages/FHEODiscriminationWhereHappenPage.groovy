package pages

import geb.Page
import geb.module.Select

class FHEODiscriminationWhereHappenPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        discriminationHeader.text() == "Where did the discrimination happen?"

    }

     static content = {

         discriminationHeader(wait:true) {$("div > h2")}
         discriminationLocation(wait:true) {$("input[id\$=discriminationLocationName]")}
         discriminationStreetAddress(wait: true) { $("input[id\$=discriminationAddress]") }
         discriminationApt(wait: true) { $("input[id\$=discriminationAptSuiteUnit]") }
         discriminationCity(wait: true) { $("input[id\$=discriminationCity]") }
         discriminationState(wait: true) { $("select[id\$=discriminationState]") }
         discriminationZip(wait: true) { $("input[id\$=discriminationZip]") }
         continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void discriminationLocation(String discLocation) {
        discriminationLocation = discLocation
    }

    void discriminationStreetAddress(String discStreetAddress) {
        discriminationStreetAddress =(""!=discStreetAddress)?discStreetAddress:""
    }

    void discriminationApt(String discApt) {
        discriminationApt =(""!=discApt)?discApt:""
    }

    void discriminationCity(String discCity) {
        discriminationCity = discCity
    }

    void discriminationState(String discState) {
         discriminationState.module(Select).selected = discState
    }

    void discriminationZip(String discZip) {
        discriminationZip =(""!=discZip)?discZip:""
    }


}