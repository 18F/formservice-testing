package specs

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import pages.IRS8821AppointeePage
import pages.IRS8821DisclosurePage
import pages.IRS8821DocumentSignedSuccessfullyPage
import pages.IRS8821SignRequestPage
import pages.IRS8821TaxInformationAuthorizationPage
import pages.IRS8821SubmitTaxInformationPage
import pages.IRS8821TaxpayerInformationPage
import pages.LoginGovCodeVerificationPage
import pages.LoginGovPage
import spock.lang.Requires
import tag.IRS8821Test
import utils.AccessibilityUtil
import utils.ExcelUtil

import javax.swing.JOptionPane

@Requires(IRS8821Test)
class IRSform8821Spec extends BaseSpec {

    def "IRS form 8821 Submission"() {
        when: "I navigate to login.gov page"
        to LoginGovPage
        user_email(data[0])
        String decuserpassword = new String(Base64.decoder.decode(data[1]))
        user_password (decuserpassword)
        signinBtn.click()

        then:
        at LoginGovCodeVerificationPage
        AccessibilityUtil.checkAccessibility("LoginGovCodeVerificationPage", driver, baseUrl)

        when: "Enter your backup security code"
 //    Use backupcodes when secondary option was selected as back up codes for the user
 //    backup_codes("TC5YYJK8K9ET")
        mfa_code()
        submitBtn.click()

        then:
        at IRS8821TaxInformationAuthorizationPage
        AccessibilityUtil.checkAccessibility("IRS8821TaxInformationAuthorizationPage", driver, baseUrl)

        when: "I start the IRS 8821 form"
        nextBtn.click()

        then:
        at IRS8821TaxpayerInformationPage
        AccessibilityUtil.checkAccessibility("IRS8821TaxpayerInformationPage", driver, baseUrl)

        when: "Fill the Tax payer information"
        WebElement element_2 = driver.findElement(By.cssSelector("input[id\$=taxpayerFirstName]"));
        element_2.clear();
        Taxpayer_firstName(data[2])

        WebElement element_3 = driver.findElement(By.cssSelector("input[id\$=taxpayerLastName]"));
        element_3.clear();
        Taxpayer_lastName(data[3])

        WebElement element_4 = driver.findElement(By.cssSelector("input[id\$=taxpayerDaytimePhoneNumber]"));
        element_4.clear();
        Taxpayer_PhoneNumber(data[4])

        WebElement element_5 = driver.findElement(By.cssSelector("input[id\$=taxpayerHomeAddress]"));
        element_5.clear();
        Taxpayer_HomeAddress(data[5])

        WebElement element_6 = driver.findElement(By.cssSelector("input[id\$=taxpayerCity]"));
        element_6.clear();
        Taxpayer_City(data[6])

        WebElement element_7 = driver.findElement(By.cssSelector("input[id\$=taxpayerState]"));
        element_7.clear();
        Taxpayer_State(data[7])

        WebElement element_8 = driver.findElement(By.cssSelector("input[id\$=taxpayerZip]"));
        element_8.clear();
        Taxpayer_Zipcode(data[8])

        WebElement element_9 = driver.findElement(By.cssSelector("input[id\$=taxpayerIdentificationNumber]"));
        element_9.clear();
        Taxpayer_IdentityNumber(data[9])

        WebElement element_10 = driver.findElement(By.cssSelector("input[id\$=taxpayerPlanNumber]"));
        element_10.clear();
        Taxpayer_planNumber(data[10])

        nextBtn.click()

        then:
        at IRS8821AppointeePage
        AccessibilityUtil.checkAccessibility("IRS8821AppointeePage", driver, baseUrl)

        when: "Fill the Appointee information"
        Appointee_firstName(data[11])
        Appointee_lastName(data[12])
        Appointee_phoneNumber(data[13])
        Appointee_Address(data[14])
        Appointee_City(data[15])
        Appointee_State(data[16])
        Appointee_Zip(data[17])
        Appointee_CFANumber(data[18])
        Appointee_PTIN(data[19])
        Appointee_FAXNumber(data[20])
        nextBtn.click()

        then:
        at IRS8821DisclosurePage
        AccessibilityUtil.checkAccessibility("IRS8821DisclosurePage", driver, baseUrl)

        when:"I select the Disclosure information"
        Disclosureoption.click()
        nextBtn.click()

        then:
        at IRS8821SubmitTaxInformationPage
        AccessibilityUtil.checkAccessibility("IRS8821SubmitTaxInformationPage", driver, baseUrl)

        when:"I select the authorization for IRS records"
        authBtn.click()
        WebElement element = driver.findElement(By.cssSelector("button[aria-label='Submit Form button. Click to submit the form']"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        submitformBtn.click()
        sleep(30000)

        then:
        at IRS8821SignRequestPage

        when: "I sign the application and finalize it"
        signature.click()
        SignaturetypeBtn.click()
        typeyoursignature()
        savesignature.click()
        finalizeBtn.click()
        sleep(3000)
        privacypolicy.click()
        sleep(3000)
        signrequest.click()

        then:
        sleep(30000)
        at IRS8821DocumentSignedSuccessfullyPage


        where:
        data << ExcelUtil.getTestData()
    }
}