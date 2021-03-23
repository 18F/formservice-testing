package pages

import geb.Page
import geb.module.Select

class FHEODiscriminationWhereHappenPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        discriminationHeader.text() == "Where did the discrimination happen?"

    }

     static content = {

         discriminationHeader(wait:true) {$("#ef1j1qf")}
         discriminationLocation(wait:true) {$("#ezhms7-discriminationLocationName")}
         discriminationStreetAddress(wait: true) { $("#eylbg9-discriminationAddress") }
         discriminationApt(wait: true) { $("#enshj3-discriminationAptSuiteUnit") }
         discriminationCity(wait: true) { $("#ex0zbih-discriminationCity") }
         discriminationState(wait: true) { $("#e7a3hwp-discriminationState") }
         discriminationZip(wait: true) { $("#e1acaq-discriminationZip") }
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