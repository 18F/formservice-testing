package specs

import com.fasterxml.jackson.databind.ObjectMapper
import io.qameta.allure.Allure
import org.json.JSONObject
import org.junit.Assert
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.chrome.ChromeDriver
//import org.openqa.selenium.devtools.DevTools
//import org.openqa.selenium.devtools.v90.fetch.model.RequestId
//import org.openqa.selenium.devtools.v90.log.model.LogEntry
//import org.openqa.selenium.devtools.v90.network.Network
//import org.openqa.selenium.devtools.v90.network.model.ResourceType
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogType
import pages.*
import spock.lang.Requires
import spock.lang.Shared
import tag.FHEORegressionSet1
import tag.FHEORegressionSet5
import utils.ExcelUtil

import java.util.regex.Pattern


@Requires(FHEORegressionSet5)
class FHEOFormSubmissionSet5Spec extends BaseSpec {
    @Shared
//    DevTools devTools
    String postData
    String xhrResponse
/*
For running this test please change the POM file to devtools which are commented out.
This test is run local and not in pipeline.
 */

    def "FHEO form submission why discrimination occurred"() {
        when: "I navigate to FHEO home page"

        to FHEOLandingPage
        submitmyComplaintBtn.click()

        then:
        at FHEOComplaintHomePage


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


        when: "I enter the data for who discriminated against you"
        enterrespondentFirstName(data[8])
        enterrespondentLastName(data[9])
        enterrespondentOrganization(data[10])
        enterrespondentPhoneNumber(data[11])
        enterrespondentEmail(data[12])
        continueBtn.click()


        then: "land on discrimination happen page"
        at FHEODiscriminationWhereHappenPage


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


         when: "I enter when the discrimination happened"
         discriminationDate.click()
         discriminationDate(data[19], data[37])
         continueBtn.click()


        then: "Click on continue"
        at FHEODiscriminationWhatHappenedPage


         when: "I enter when the discrimination happen"
         discriminationDescription(data[20])
         continueBtn.click()


        then: "Click on continue"
        at FHEODiscriminationHowToContactYouPage


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
        devTools =  ((ChromeDriver)driver).getDevTools()
        devTools.createSession()

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()))

        continueBtn.click()
        devTools.addListener(Network.requestWillBeSent(), { request ->
            try {
                postData = devTools.send(Network.getRequestPostData(request.getRequestId()))
            }
            catch (WebDriverException wde) {

            }

        })
        devTools.send(Network.disable())

        then: "Click on continue"
        at FHEODiscriminationReviewAndSubmitPage


        when: "I click on the submit button"
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()))
        devTools.addListener(Network.responseReceived(), { responseReceived ->
            if (ResourceType.XHR != responseReceived.getType()) {
                return
            }
                xhrResponse= devTools.send(Network.getResponseBody(responseReceived.getRequestId())).getBody()
        })
        submitBtn.click()

        then: " I am at the conformation page"
        at FHEODiscriminationConfirmationPage

        when:
        JSONObject postJson = new JSONObject(postData)
        JSONObject xhrResponseJson = new JSONObject(xhrResponse)
        Allure.description("ID of XHR is " + xhrResponseJson.getString("_id").toString())
        then:
        compareRequestResponse(postJson, xhrResponseJson)

        where:
        data << ExcelUtil.getTestData()


    }

    def cleanup(){
        devTools.send(Network.disable())
    }


    boolean compareRequestResponse(JSONObject request, JSONObject response){
        assert request.getJSONObject("data").getString("otherReasonDescription") == response.getJSONObject("data").getString("otherReasonDescription")
        assert request.getJSONObject("data").getString("respondentFirstName") == response.getJSONObject("data").getString("respondentFirstName")
        assert request.getJSONObject("data").getString("respondentOrganization") == response.getJSONObject("data").getString("respondentOrganization")
        assert request.getJSONObject("data").getString("respondentPhoneNumber") == response.getJSONObject("data").getString("respondentPhoneNumber")
        assert request.getJSONObject("data").getString("respondentEmail") == response.getJSONObject("data").getString("respondentEmail")
        assert request.getJSONObject("data").getString("discriminationLocationName") == response.getJSONObject("data").getString("discriminationLocationName")
        assert request.getJSONObject("data").getString("discriminationAddress") == response.getJSONObject("data").getString("discriminationAddress")
        assert request.getJSONObject("data").getString("discriminationAptSuiteUnit") == response.getJSONObject("data").getString("discriminationAptSuiteUnit")
        assert request.getJSONObject("data").getString("discriminationCity") == response.getJSONObject("data").getString("discriminationCity")
        assert request.getJSONObject("data").getString("discriminationState") == response.getJSONObject("data").getString("discriminationState")
        assert request.getJSONObject("data").getString("discriminationZip") == response.getJSONObject("data").getString("discriminationZip")
        assert request.getJSONObject("data").getString("discriminationDescription") == response.getJSONObject("data").getString("discriminationDescription")
        assert request.getJSONObject("data").getString("complainantFirstName") == response.getJSONObject("data").getString("complainantFirstName")
        assert request.getJSONObject("data").getString("complainantPhoneNumber") == response.getJSONObject("data").getString("complainantPhoneNumber")
        assert request.getJSONObject("data").getString("complainantEmail") == response.getJSONObject("data").getString("complainantEmail")
        assert request.getJSONObject("data").getString("complainantBestTimeToContactYou") == response.getJSONObject("data").getString("complainantBestTimeToContactYou")
        assert request.getJSONObject("data").getString("complainantAddress") == response.getJSONObject("data").getString("complainantAddress")
        assert request.getJSONObject("data").getString("complainantAptSuiteUnit") == response.getJSONObject("data").getString("complainantAptSuiteUnit")
        assert request.getJSONObject("data").getString("complainantCity") == response.getJSONObject("data").getString("complainantCity")
        assert request.getJSONObject("data").getString("complainantState") == response.getJSONObject("data").getString("complainantState")
        assert request.getJSONObject("data").getString("complainantZip") == response.getJSONObject("data").getString("complainantZip")
        assert request.getJSONObject("data").getString("alternateContactFirstName") == response.getJSONObject("data").getString("alternateContactFirstName")
        assert request.getJSONObject("data").getString("alternateContactLastName") == response.getJSONObject("data").getString("alternateContactLastName")
        assert request.getJSONObject("data").getString("alternateContactRelationship") == response.getJSONObject("data").getString("alternateContactRelationship")
        assert request.getJSONObject("data").getString("alternativeContactOtherRelationshipDescription") == response.getJSONObject("data").getString("alternativeContactOtherRelationshipDescription")
        assert request.getJSONObject("data").getString("alternateContactPhoneNumber") == response.getJSONObject("data").getString("alternateContactPhoneNumber")
        assert request.getJSONObject("data").getString("alternateContactEmail") == response.getJSONObject("data").getString("alternateContactEmail")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("race") == response.getJSONObject("data").getJSONObject("reason").getBoolean("race")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("nationalorigin") == response.getJSONObject("data").getJSONObject("reason").getBoolean("nationalorigin")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("religion") == response.getJSONObject("data").getJSONObject("reason").getBoolean("religion")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("sex") == response.getJSONObject("data").getJSONObject("reason").getBoolean("sex")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("disability") == response.getJSONObject("data").getJSONObject("reason").getBoolean("disability")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("familialstatus") == response.getJSONObject("data").getJSONObject("reason").getBoolean("familialstatus")
        assert request.getJSONObject("data").getJSONObject("reason").getBoolean("other") == response.getJSONObject("data").getJSONObject("reason").getBoolean("other")

        return true

    }
}