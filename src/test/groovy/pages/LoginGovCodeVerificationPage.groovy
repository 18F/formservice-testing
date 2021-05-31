package pages

import geb.Page

class LoginGovCodeVerificationPage extends Page {

         static at = { title == "login.gov - Enter the secure one-time security code"}

        static content = {
            backup_codes(wait:true) { $("input[id\$=backup_code_verification_form_backup_code]") }
            submitBtn(wait:true) { $("input[value='Submit']")}
    }

    void backup_codes(String Security_code) {
        backup_codes << Security_code
    }

}