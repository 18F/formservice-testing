package pages

import geb.Page

class IRS8821SignRequestPage extends Page {

    static at = { title == "Sign document f8821.pdf sent by gsat69101@gmail.com - Signrequest" }

    static content = {
        signature(wait: true) { $("div[title='Place Signature here']") }
        SignaturetypeBtn(wait: true) { $("button[title='Use Herr Von Muellerhoff font for signature']") }
        typeyoursignature(wait: true) { $("input[aria-label='Type your name']") }
        savesignature(wait: true) { $("button[data-test-id=\"submit\"]") }
        finalizeBtn(wait: true) { $("#document-finalize") }
        privacypolicy(wait: true) {$("input[name='terms']")}
        signrequest(wait:true) {$("div.v-card__actions > button")}

    }

    void typeyoursignature(){
        typeyoursignature << "formIRS8821"
    }

    /*void tokenverification() {

    }*/
}