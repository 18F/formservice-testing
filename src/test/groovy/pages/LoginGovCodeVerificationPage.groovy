package pages

import geb.Page

import javax.swing.JOptionPane

class LoginGovCodeVerificationPage extends Page {

         static at = { title == "login.gov - Enter the secure one-time security code"}

        static content = {
            backup_codes(wait:true) { $("input[id\$=backup_code_verification_form_backup_code]") }
            submitBtn(wait:true) { $("input[value='Submit']")}
            mfa_code(wait:true) { $("input[id\$=code]") }
    }

    void backup_codes(String security_code) {
        backup_codes << security_code
    }

    void mfa_code() {
        String mfaCode = JOptionPane.showInputDialog(null, "Enter MFA Code");
        mfa_code << mfaCode
    }

}