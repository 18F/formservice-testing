import com.browserstack.local.Local
import org.openqa.selenium.Capabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.os.ExecutableFinder
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS


String browserStackUserName = "test_v4DB8aFXy6j"
String browserStackAutomateKey = "d6WnNpVDsaFeuxrKU7z7"
String url = "https://" + browserStackUserName + ":" + browserStackAutomateKey + "@hub.browserstack.com/wd/hub"


File findDriverExecutable() {
    def defaultExecutable = new ExecutableFinder().find("chromedriver")
    if (defaultExecutable) {
        new File(defaultExecutable)
    } else {
        new File("drivers").listFiles().findAll {
            !it.name.endsWith(".version")
        }.find {
            if (IS_OS_LINUX) {
                it.name.contains("linux")
            } else if (IS_OS_MAC) {
                it.name.contains("mac")
            } else if (IS_OS_WINDOWS) {
                it.name.contains("windows")
            }
        }
    }
}

environments {


    chrome {
        driver = {



            Capabilities capabilities = new DesiredCapabilities()
            capabilities.setCapability("build", "Geb-Tests");
            capabilities.setCapability("browserName", System.getProperty("browser"));
            capabilities.setCapability("browserVersion", System.getProperty("browser_version"));
            capabilities.setCapability("os", System.getProperty("os"));
            capabilities.setCapability("os_version", System.getProperty("os_version"));
            capabilities.setCapability("device", System.getProperty("device"));
            capabilities.setCapability("real_mobile", System.getProperty("real_mobile"));
            if ((System.getProperty("local") != null) && (System.getProperty("local").equalsIgnoreCase("true"))) {

                ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .usingDriverExecutable(findDriverExecutable())
                driver = new ChromeDriver(serviceBuilder.build())
            } else {
                driver = new RemoteWebDriver(new URL(url), capabilities)
            }




        }
    }

}

waiting {
    timeout = 10
    retryInterval = 0.5
}

String calculateBaseUrl(){
    if (System.getProperty("env")== 'fheodev') {
        "https://fheo.app.cloud.gov/"
    }
    else if (System.getProperty("env")== 'fheodark'){
        "https://fheo-dark.app.cloud.gov/"
    }

}

baseUrl=calculateBaseUrl()
