package pages

import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

class FHEODiscriminationReasonPage extends Page {

    static at = { title == "HUD Housing Discrimination Complaint"
        respondentheader.text() == "Who discriminated against you?"

    }

     static content = {

         respondentheader(wait:true) {$("div > h2")}
         respondentFirstName(wait: true) { $("input[id\$=respondentFirstName]") }
         respondentLastName(wait: true) { $("input[id\$=respondentLastName") }
         respondentOrganization(wait: true) { $("input[id\$=respondentOrganization") }
         respondentPhoneNumber(wait: true) { $("input[id\$=respondentPhoneNumber") }
         respondentEmail(wait: true) { $("input[id\$=respondentEmail") }
         continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }

    }

    void enterrespondentFirstName(String respFirstName) {
           respondentFirstName=(""!= respFirstName)?respFirstName:""
    }

    void enterrespondentLastName(String respLastName) {
            respondentLastName =(""!= respLastName)?respLastName:""
    }

    void enterrespondentOrganization(String respOrganization) {
            respondentOrganization =(""!= respOrganization)?respOrganization:""
    }

    void enterrespondentPhoneNumber(String respPhoneNumber) {
    if (System.getProperty("device") == null)
    {
        respondentPhoneNumber =(""!=respPhoneNumber)?respPhoneNumber:""
    }
    else if ((System.getProperty("device") == 'Samsung Galaxy S20') || (System.getProperty("device") == 'Samsung Galaxy Tab S7'))
    {
        respPhoneNumber.each { it ->
            respondentPhoneNumber << it
        }
    }
    else if ((System.getProperty("device") == 'iPhone 12 Pro') || (System.getProperty("device") == 'iPad Air 4'))
    {

        WebElement element = driver.findElement(By.cssSelector("input[id\$=respondentPhoneNumber"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', Number(${respPhoneNumber}))", element);
    }
    }


    void enterrespondentEmail(String respEmail) {
            respondentEmail =(""!=respEmail)?respEmail:""
    }

}