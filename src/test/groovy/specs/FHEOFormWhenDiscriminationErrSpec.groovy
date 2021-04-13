package specs

import pages.*
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegression
import tag.FHEOShakeOut
import utils.AccessibilityUtil

@Requires(FHEOShakeOut)
class FHEOFormWhenDiscriminationErrSpec extends BaseSpec {

    @Unroll
    def "FHEO form submission why discrimination occurred for error message #errMsg4"(String errMsg4) {
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
        clickFamilyDiscriminationCheckbox("Yes")
        clickOtherReasonDiscriminationCheckbox("", "")
        continueBtn.click()

        then: "land on discrimination reason page"
        at FHEODiscriminationReasonPage

        when: "I enter the data for who discriminated against you"
        enterrespondentFirstName("")
        enterrespondentLastName("")
        enterrespondentOrganization("")
        enterrespondentPhoneNumber("")
        enterrespondentEmail("")
        continueBtn.click()

        then: "land on where discrimination happen page"
        at FHEODiscriminationWhereHappenPage

        when: "I enter the data for where the discrimination occur"
        discriminationLocation("s")
        discriminationStreetAddress("")
        discriminationApt("")
        discriminationCity("s")
        discriminationState("ME - Maine")
        discriminationZip("")
        continueBtn.click()

        then: "Click on continue"
        at FHEODiscriminationDatePage
        continueBtn.click()
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationDatePage.url.toString())
        checkErrMsg4(errMsg4)


        where:
        errMsg4 <<
                ["Please enter a date within the last year. By law, we can only investigate discrimination that happened in the last year. If the last date you experienced discrimination was more than a year ago, call your nearest HUD fair housing office for more information."]

    }
}