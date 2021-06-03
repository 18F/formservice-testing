package pages

import geb.Page

class LoginGovPage extends Page {

        static content = {
            user_email(wait:true) { $("input[id\$=user_email]") }
            user_password(wait:true) { $("input[id\$=user_password]") }
            signinBtn(wait:true) { $("input[value='Sign in']")}
    }

    void user_email(String useremail) {
        user_email << useremail
    }

    void user_password(String decuserpassword) {
        user_password << decuserpassword
    }

}