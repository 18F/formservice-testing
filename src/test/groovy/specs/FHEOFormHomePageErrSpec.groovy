package specs

import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegressionErrSpec
import utils.AccessibilityUtil

@Requires(FHEORegressionErrSpec)
class FHEOFormHomePageErrSpec extends BaseSpec {

    @Unroll
    def "FHEO form submission why discrimination occurred for error message #errMsg"(String data, String errMsg, String otherdata, String otherMsg) {
        when: "I navigate to FHEO home page"
        to FHEOLandingPage
        submitmyComplaintBtn.click()

        then:
        at FHEOComplaintHomePage

        when: "I select the reason why discrimination occurred"
        clickRaceDiscriminationCheckbox()
        clickReligionDiscriminationCheckbox()
        clickOriginDiscriminationCheckbox()
        clickGenderDiscriminationCheckbox()
        clickDisabilityDiscriminationCheckbox()
        clickFamilyDiscriminationCheckbox(data)
        clickOtherReasonDiscriminationCheckbox(otherdata, "")
        waitFor {
            continueBtn.click()
        }
        then: "At Homepage verify the error message"
        at FHEOComplaintHomePage
        checkErrMsg(errMsg)

        checkOtherErrMsg(otherMsg)


        where:
        data | errMsg                             | otherdata | otherMsg
        "No" | "Please check at least one reason" | ""        | ""
        "No" | ""                                 | "Yes"     | "Please provide a short description of why you were discriminated against"

    }

}
