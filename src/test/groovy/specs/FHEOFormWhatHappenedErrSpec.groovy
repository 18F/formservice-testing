package specs

import pages.FHEOComplaintHomePage
import pages.FHEODiscriminationDatePage
import pages.FHEODiscriminationReasonPage
import pages.FHEODiscriminationWhatHappenedPage
import pages.FHEODiscriminationWhereHappenPage
import pages.FHEOLandingPage
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegression
import tag.FHEOShakeOut

@Requires(FHEOShakeOut)
class FHEOFormWhatHappenedErrSpec extends BaseSpec{

    @Unroll
    def "FHEO form submission why discrimination occurred for error message #errMsg5"(String errMsg5) {
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

        when: "I enter when the discrimination happened"
        discriminationDate("03-04-2021")
        calenderBtn.click()
        continueBtn.click()

        then: "Click on continue"
        at FHEODiscriminationWhatHappenedPage

        when: "I enter when the discrimination happen"
        discriminationDescription("")
        continueBtn.click()

        then:
        checkErrMsg5(errMsg5)

        where:
        errMsg5 <<
                ["Please provide a summary of the events that happened"]

    }
}
