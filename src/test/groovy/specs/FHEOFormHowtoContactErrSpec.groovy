package specs

import pages.FHEOComplaintHomePage
import pages.FHEODiscriminationDatePage
import pages.FHEODiscriminationHowToContactYouPage
import pages.FHEODiscriminationReasonPage
import pages.FHEODiscriminationWhatHappenedPage
import pages.FHEODiscriminationWhereHappenPage
import pages.FHEOLandingPage
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegression
import tag.FHEOShakeOut

@Requires(FHEOShakeOut)
class FHEOFormHowtoContactErrSpec extends BaseSpec {

    @Unroll
    def "FHEO form submission why discrimination occurred for error message #errMsg6"(String errMsg6,String errMsg7,String errMsg8,String errMsg9,String errMsg10,String errMsg11,String errMsg12) {
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
        discriminationDescription("S")
        continueBtn.click()

        then: "Click on continue"
        at FHEODiscriminationHowToContactYouPage

        when: "I enter how to contact you information"
        discriminationcomplainantFirstName("")
        discriminationcomplainantLastName("")
        discriminationcomplainantPhoneNumber("")
        discriminationcomplainantEmail("")
        discriminationcomplainantBestTimeToContactYou("")
        discriminationcomplainantAddress("")
        discriminationcomplainantAptSuiteUnit("")
        discriminationcomplainantCity("")
        discriminationcomplainantState("")
        discriminationcomplainantZip("")
        discriminationaltContactFirstName("")
        discriminationaltContactLastName("")
        discriminationaltContactRelationship("", "")
        discriminationaltContactPhoneNumber("")
        discriminationaltContactEmail("")
        continueBtn.click()

        then:
        at FHEODiscriminationHowToContactYouPage
        checkErrMsg6(errMsg6)
        checkErrMsg7(errMsg7)
        checkErrMsg8(errMsg8)
        checkErrMsg9(errMsg9)
        checkErrMsg10(errMsg10)
        checkErrMsg11(errMsg11)
        checkErrMsg12(errMsg12)

        where:
        errMsg6                        | errMsg7                       | errMsg8                          | errMsg9                            | errMsg10                 | errMsg11                  | errMsg12
        "Please enter your first name" | "Please enter your last name" | "Please enter your phone number" | "Please enter your street address" | "Please enter your city" | "Please enter your state" | "Please enter your ZIP code"


    }

}
