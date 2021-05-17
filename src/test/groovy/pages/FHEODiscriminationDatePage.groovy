package pages

import geb.Page
import geb.module.Select
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

class FHEODiscriminationDatePage extends Page {

    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationdateHeader.text() == "When did the discrimination happen?"

    }

    static content = {

        discriminationdateHeader(wait: true) { $("div > h2") }
        discriminationDate(wait: true) { $("input[id\$=discriminationDate]") }
        monthDropdown(wait: true) { $(".flatpickr-monthDropdown-months") }
        continueBtn(wait: true) { $("button[aria-label=\"CONTINUE button. Click to go to the next tab\"]") }
        calenderBtn(wait: true) { $("i.fa.fa-calendar") }
        errMsg4(wait: true, required: false) { $("span[id\$=discriminationDate]") }

    }

    void discriminationDate(String date, String dateWithTimestamp) {

        if (System.getProperty("device") == null) {
            discriminationDate << date

        } else if ((System.getProperty("device") == 'Samsung Galaxy S20') || (System.getProperty("device") == 'Samsung Galaxy Tab S7') || (System.getProperty("device") == 'iPhone 12 Pro')) {
            WebElement element
            JavascriptExecutor jsExecutor
            element = driver.findElement(By.cssSelector(".usa-input.maxw-full.flatpickr-input"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(date)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'date')", element);

            element = driver.findElement(By.cssSelector("input[id\$=discriminationDate]"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(dateWithTimestamp)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'hidden')", element);

            element = driver.findElement(By.cssSelector(".usa-input.maxw-full.form-control.input"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(date)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'hidden')", element)
        }
        else if ((System.getProperty("device") == 'iPad Air 4')) {
            WebElement element
            JavascriptExecutor jsExecutor
            element = driver.findElement(By.cssSelector(".usa-input.maxw-full"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(date)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'date')", element);

            element = driver.findElement(By.cssSelector("input[id\$=discriminationDate]"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(dateWithTimestamp)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'hidden')", element);

            element = driver.findElement(By.cssSelector(".usa-input.maxw-full"));
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('type', '')", element);
            element.sendKeys(date)
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'hidden')", element)

        }
    }

    boolean checkErrMsg4(String errMessage4) {
        if (errMessage4 != "") {
            waitFor {errMsg4.text() == errMessage4}
        }
        true
    }

}