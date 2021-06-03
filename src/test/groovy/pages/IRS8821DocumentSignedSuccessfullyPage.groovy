package pages

import geb.Page

class IRS8821DocumentSignedSuccessfullyPage extends Page {

         static at = { title == "Form Service"}

        static content = {
            confirmation(wait: true) { $("div > h3['Document Signed Successfully']") }
    }

}