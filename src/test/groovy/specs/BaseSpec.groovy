package specs

import geb.spock.GebReportingSpec

class BaseSpec extends GebReportingSpec {

    def setup(){
        driver.manage().window().maximize()
    }
}