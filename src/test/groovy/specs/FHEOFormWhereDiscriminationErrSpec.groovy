package specs

import pages.FHEOComplaintHomePage
import pages.FHEODiscriminationReasonPage
import pages.FHEODiscriminationWhereHappenPage
import pages.FHEOLandingPage
import spock.lang.Requires
import spock.lang.Unroll
import tag.FHEORegression
import tag.FHEOShakeOut

@Requires(FHEOShakeOut)
class FHEOFormWhereDiscriminationErrSpec extends BaseSpec {

    @Unroll
    def "FHEO form submission why discrimination occurred for error message #errMsg1"(String errMsgs1, String errMsgs2,
                                                                                     String errMsgs3) {
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
        discriminationLocation("")
        discriminationStreetAddress("")
        discriminationApt("")
        discriminationCity("")
        discriminationState("")
        discriminationZip("")
        continueBtn.click()

        then: "on where screen verify the error message"
        at FHEODiscriminationWhereHappenPage
        checkErrMsg1(errMsgs1)
        checkErrMsg2(errMsgs2)
        checkErrMsg3(errMsgs3)

        where:
        errMsgs1                                                                                                        | errMsgs2                                                  | errMsgs3
        "Please enter the name of the building, apartment complex, or other location where the discrimination happened" | "Please enter the city where the discrimination happened" | "Please enter the state where the discrimination happened"


    }
}