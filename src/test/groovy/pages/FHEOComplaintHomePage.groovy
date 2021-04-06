package pages

import geb.Page

class FHEOComplaintHomePage extends Page {


    static url = "/fheo"

    static at = { title == "HUD Housing Discrimination Complaint" }

    static content = {

        raceDiscrimination(wait: true) { $("div.usa-checkbox > label", text:contains("race or skin color")) }
        nationalOrigin(wait: true) { $("div.usa-checkbox > label", text:contains("national origin (ancestry or ethnicity")) }
        religionDiscrimination(wait: true) { $("div.usa-checkbox > label", text:contains("religion")) }
        gender(wait: true) { $("div.usa-checkbox > label", text:contains("sex, gender identity, or sexual orientation or because I was sexually harassed")) }
        disability(wait: true) { $("div.usa-checkbox > label", text:contains("disability")) }
        family(wait: true) { $("b > label[for\$='reason.familialstatus']") }
        otherReason(wait: true) { $("div.usa-checkbox > label", text:contains("Other reason")) }
        otherDescription(wait: true) { $("input[id\$=otherReasonDescription]") }
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