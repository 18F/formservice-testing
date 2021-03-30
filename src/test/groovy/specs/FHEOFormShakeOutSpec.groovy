package specs

import pages.FHEOComplaintHomePage
import pages.FHEOLandingPage
import spock.lang.Requires
import tag.ShakeOut

@Requires(ShakeOut)
class FHEOFormShakeOutSpec extends BaseSpec {

    def "FHEO form submission why discrimination occurred"() {
        when: "I navigate to FHEO home page"
        to FHEOLandingPage
        submitmyComplaintBtn.click()

        then:
        at FHEOComplaintHomePage

    }
}