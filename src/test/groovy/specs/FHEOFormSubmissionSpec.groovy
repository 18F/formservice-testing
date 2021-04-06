package specs


import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import pages.FHEODiscriminationReasonPage
import pages.FHEODiscriminationWhereHappenPage
import pages.FHEODiscriminationDatePage
import pages.FHEODiscriminationWhatHappenedPage
import pages.FHEODiscriminationHowToContactYouPage
import pages.FHEODiscriminationReviewAndSubmitPage
import pages.FHEODiscriminationConfirmationPage
import spock.lang.Requires
import tag.Regression
import tag.ShakeOut
import utils.AccessibilityUtil
import utils.ExcelUtil

@Requires(Regression)
class FHEOFormSubmissionSpec extends BaseSpec {

    def "FHEO form submission why discrimination occurred"() {
        when: "I navigate to FHEO home page"
        to FHEOLandingPage
        AccessibilityUtil.checkAccessibility(driver, baseUrl)
        submitmyComplaintBtn.click()

        then:
        at FHEOComplaintHomePage
        AccessibilityUtil.checkAccessibility(driver, FHEOComplaintHomePage.url.toString())

        when: "I select the reason why discrimination occurred"
        clickRaceDiscriminationCheckbox(data[0])
        clickReligionDiscriminationCheckbox(data[1])
        clickOriginDiscriminationCheckbox(data[2])
        clickGenderDiscriminationCheckbox(data[3])
        clickDisabilityDiscriminationCheckbox(data[4])
        clickFamilyDiscriminationCheckbox(data[5])
        clickOtherReasonDiscriminationCheckbox(data[6], data[7])
        continueBtn.click()



        then: "land on dicrimination reason page"
        at FHEODiscriminationReasonPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationReasonPage.url.toString())

        when: "I enter the data for who discriminated against you"
        enterrespondentFirstName(data[8])
        enterrespondentLastName(data[9])
        enterrespondentOrganization(data[10])
        enterrespondentPhoneNumber(data[11])
        enterrespondentEmail(data[12])
        continueBtn.click()


        then: "land on discrimination happen page"
        at FHEODiscriminationWhereHappenPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationWhereHappenPage.url.toString())

        when: "I enter the data for where the discrimination occur"
        discriminationLocation(data[13])
        discriminationStreetAddress(data[14])
        discriminationApt(data[15])
        discriminationCity(data[16])
        discriminationState(data[17])
        discriminationZip(data[18])
        continueBtn.click()


         then: "Click on continue"
         at FHEODiscriminationDatePage
         AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationDatePage.url.toString())

         when: "I enter when the discrimination happened"
         discriminationDate.click()
         discriminationDate(data[19])
         continueBtn.click()


        then: "Click on continue"
        at FHEODiscriminationWhatHappenedPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationWhatHappenedPage.url.toString())

         when: "I enter when the discrimination happen"
         discriminationDescription(data[20])
         continueBtn.click()


        then: "Click on continue"
        at FHEODiscriminationHowToContactYouPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationHowToContactYouPage.url.toString())

        when: "I enter how to contact you information"

        discriminationcomplainantFirstName(data[21])
        discriminationcomplainantLastName(data[22])
        discriminationcomplainantPhoneNumber(data[23])
        discriminationcomplainantEmail(data[24])
        discriminationcomplainantBestTimeToContactYou(data[25])
        discriminationcomplainantAddress(data[26])
        discriminationcomplainantAptSuiteUnit(data[27])
        discriminationcomplainantCity(data[28])
        discriminationcomplainantState(data[29])
        discriminationcomplainantZip(data[30])
        discriminationaltContactFirstName(data[31])
        discriminationaltContactLastName(data[32])
        discriminationaltContactRelationship(data[33],data[34])
        discriminationaltContactPhoneNumber(data[35])
        discriminationaltContactEmail(data[36])
        continueBtn.click()


        then: "Click on continue"
        at FHEODiscriminationReviewAndSubmitPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationReviewAndSubmitPage.url.toString())

        when: "I click on the submit button"
        submitBtn.click()


        then: " I am at the conformation page"
        at FHEODiscriminationConfirmationPage
        AccessibilityUtil.checkAccessibility(driver, FHEODiscriminationConfirmationPage.url.toString())


        where:
        data << ExcelUtil.getTestData()
    }
}