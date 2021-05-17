package pages

import geb.Page
import geb.module.Select
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

class FHEODiscriminationWhereHappenPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        discriminationHeader.text() == "Where did the discrimination happen?"

    }

     static content = {

         discriminationHeader(wait:true) {$("div > h2")}
         discriminationLocation(wait:true) {$("input[id\$=discriminationLocationName]")}
         discriminationStreetAddress(wait: true) { $("input[id\$=discriminationAddress]") }
         discriminationApt(wait: true) { $("input[id\$=discriminationAptSuiteUnit]") }
         discriminationCity(wait: true) { $("input[id\$=discriminationCity]") }
         discriminationState(wait: true) { $("select[id\$=discriminationState]") }
         discriminationZip(wait: true) { $("input[id\$=discriminationZip]") }
         continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }
         errMsgs1(wait: true, required: false) { $("span[id\$=discriminationLocationName]") }
         errMsgs2(wait: true, required: false) { $("span[id\$=discriminationCity]") }
         errMsgs3(wait: true, required: false) { $("span[id\$=discriminationState]") }

    }

    void discriminationLocation(String discLocation) {
        discriminationLocation = discLocation
    }

    void discriminationStreetAddress(String discStreetAddress) {
        discriminationStreetAddress =(""!=discStreetAddress)?discStreetAddress:""
    }

    void discriminationApt(String discApt) {
        discriminationApt =(""!=discApt)?discApt:""
    }

    void discriminationCity(String discCity) {
        discriminationCity = discCity
    }

    void discriminationState(String discState) {
         discriminationState.module(Select).selected = discState
    }

    void discriminationZip(String discZip) {
    if (System.getProperty("device") == null)
    {
        discriminationZip =(""!=discZip)?discZip:""
    }
    else if ((System.getProperty("device") == 'Samsung Galaxy S20') || (System.getProperty("device") == 'Samsung Galaxy Tab S7'))
    {
        discZip.each { it ->
        discriminationZip << it
        }
    }
    else if ((System.getProperty("device") == 'iPhone 12 Pro') || (System.getProperty("device") == 'iPad Air 4'))
    {

        WebElement element = driver.findElement(By.cssSelector("input[id\$=discriminationZip]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', Number(${discZip}))", element);
    }
    }

    boolean checkErrMsg1(String errMessage1) {
        if (errMessage1 != "") {
           waitFor { errMsgs1.text() == errMessage1}
        }
    }

    boolean checkErrMsg2(String errMessage2) {
        if (errMessage2 != "") {
            waitFor {errMsgs2.text() == errMessage2}
        }
    }

    boolean checkErrMsg3(String errMessage3) {
        if (errMessage3 != "") {
            waitFor {errMsgs3.text() == errMessage3}
        }
    }


}