package specs


import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import spock.lang.Requires
import tag.ShakeOut
import utils.AccessibilityUtil

@Requires(ShakeOut)
class FHEOFormShakeOutSpec extends BaseSpec {

    def "FHEO form submission why discrimination occurred"() {
        when: "I navigate to FHEO home page"
        to FHEOLandingPage

        AccessibilityUtil.checkAccessibility(driver)
        submitmyComplaintBtn.click()



        then:
        at FHEOComplaintHomePage
        AccessibilityUtil.checkAccessibility(driver)
    }
}