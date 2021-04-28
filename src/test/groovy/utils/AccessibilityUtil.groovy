package utils

import com.deque.axe.AXE
import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.WebDriver


class AccessibilityUtil {
    private static final URL scriptUrl = AccessibilityUtil.class.getResource("/axe.min.js");


    static void checkAccessibility(String fileName="test", WebDriver driver, String url) {
        if ("true".equalsIgnoreCase(System.getProperty("checkAccessibility"))) {
            JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

            JSONArray violations = responseJSON.getJSONArray("violations");

            if (violations.length() == 0) {
                println("No violations found")
            } else {
//                println("Accessibility Violations found in " + url)
                writeAxeResults(fileName, AXE.report(violations));
//                println(AXE.report(violations))
            }

        }
    }

    static void writeAxeResults(String name, Object output) {
        BufferedWriter writer = null;
        File directory = new File("target/accessibilityReport");
        if (! directory.exists()){
            directory.mkdir();
        }

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("target/accessibilityReport/" +name + ".txt")), "utf-8"));
            writer.write(output.toString());
        } catch (IOException var12) {
        } finally {
            try {
                writer.close();
            } catch (Exception var11) {
            }

        }

    }
}