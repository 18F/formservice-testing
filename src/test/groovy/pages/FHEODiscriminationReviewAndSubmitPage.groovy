package pages

import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

class FHEODiscriminationReviewAndSubmitPage extends Page {

    static at = {
        title == "HUD Housing Discrimination Complaint"
        discriminationReviewandSubmitHeader.text() == "Review and submit your complaint"

    }

    static content = {

        discriminationReviewandSubmitHeader(wait: true) { $("div > h2") }
        submitBtn(wait: true) { $("button[aria-label=\"SUBMIT MY COMPLAINT button. Click to submit the form\"]") }

    }

    void submitPage(){
        JavascriptExecutor jsExecutor
        def response= jsExecutor.executeAsyncScript(
                "var url = arguments[0];" +
                        "var callback = arguments[arguments.length - 1];" +
                        "var xhr = new XMLHttpRequest();" +
                        "xhr.open('GET', url, true);" +
                        "xhr.onreadystatechange = function() {" +
                        "  if (xhr.readyState == 4) {" +
                        "    callback(xhr.getAllResponseHeaders());" +
                        "  }" +
                        "};" +
                        "xhr.send();", url);

        print "response is -------------- " + response
    }



}