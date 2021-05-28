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
        useremail(data[0])
        userpassword(data[1])

        then:
        2==2

        where:
        data << ExcelUtil.getTestData()
    }
}