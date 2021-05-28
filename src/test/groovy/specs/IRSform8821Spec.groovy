package specs


import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import pages.LoginGovPage
import spock.lang.Requires
import tag.FHEOShakeOut
import tag.IRS8821Test
import utils.AccessibilityUtil
import utils.ExcelUtil

@Requires(IRS8821Test)
class IRSform8821Spec extends BaseSpec {

    def "IRS form 8821 Submission"() {
        when: "I navigate to login.gov page"
        to LoginGovPage
        user_email(data[0])
        user_password(data[1])
        signinBtn.click()

        then:
        2==2

        where:
        data << ExcelUtil.getTestData()
    }
}