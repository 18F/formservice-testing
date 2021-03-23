package pages

import geb.Page

class FHEOComplaintHomePage extends Page {

  //  static url = "/fheo"

    static at = { title == "HUD Housing Discrimination Complaint" }

    static content = {

        raceDiscrimination(wait: true) { $("#ey0hnwq > div.usa-checkbox > label") }
        religionDiscrimination(wait: true) { $("#eljfpt > div.usa-checkbox > label") }
        nationalOrigin(wait: true) { $("#e4mhob > div.usa-checkbox > label") }
        gender(wait: true) { $("#ez21ek > div.usa-checkbox > label") }
        disability(wait: true) { $("#e24ywvln > div.usa-checkbox > label") }
        family(wait: true) { $("#exfk9c > div.usa-checkbox > label") }
        otherReason(wait: true) { $("#e34dvr > div.usa-checkbox > label") }
        otherDescription(wait: true) { $("#eea6pj8-otherReasonDescription") }
        continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void clickRaceDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            raceDiscrimination.click()
        }
    }

    void clickReligionDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            religionDiscrimination.click()
        }
    }

    void clickOriginDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            nationalOrigin.click()
        }
    }

    void clickGenderDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            gender.click()
        }
    }

    void clickDisabilityDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            disability.click()
        }
    }

    void clickFamilyDiscriminationCheckbox(String optionSelect) {
        if (optionSelect == "Yes") {
            family.click()
        }
    }

    void clickOtherReasonDiscriminationCheckbox(String optionSelect, String description) {
        if (optionSelect == "Yes") {
            otherReason.click()
            otherDescription = description
        }
    }


}