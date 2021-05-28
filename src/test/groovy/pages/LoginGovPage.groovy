package pages

import geb.Page

class LoginGovPage extends Page {

        static content = {
            useremail(wait:true) { $("input[id\$=user_email]") }
            userpassword(wait:true) { $("input[id\$=user_password]") }
    }

    void useremail(String useremail) {
        useremail = useremail
    }

    void userpassword(String userpassword) {
        userpassword = userpassword
    }

}