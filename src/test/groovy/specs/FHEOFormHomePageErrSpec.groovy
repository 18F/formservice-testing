package specs

import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegression
import tag.FHEOShakeOut
import utils.AccessibilityUtil

@Requires(FHEORegression)
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
        continueBtn.click()

        then: "At Homepage verify the error message"
        at FHEOComplaintHomePage
        checkErrMsg(errMsg)
        AccessibilityUtil.checkAccessibility(driver, FHEOComplaintHomePage.url.toString())
        checkOtherErrMsg(otherMsg)
        AccessibilityUtil.checkAccessibility(driver, FHEOComplaintHomePage.url.toString())

        where:
        data | errMsg                             | otherdata | otherMsg
        "No" | "Please check at least one reason" | ""        | ""
        "No" | ""                                 | "Yes"     | "Please provide a short description of why you were discriminated against"

    }

}
