package utils

import com.deque.axe.AXE
import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.WebDriver


class AccessibilityUtil {
    private static final URL scriptUrl = AccessibilityUtil.class.getResource("/axe.min.js");


    static void checkAccessibility(WebDriver driver) {
        if ("true".equalsIgnoreCase(System.getProperty("checkAccessibility"))) {
            JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

            JSONArray violations = responseJSON.getJSONArray("violations");

            if (violations.length() == 0) {
                println("No violations found")
            } else {
                AXE.writeResults(this.getClass().toString(), responseJSON);
                println(AXE.report(violations))
            }

        }
    }
}