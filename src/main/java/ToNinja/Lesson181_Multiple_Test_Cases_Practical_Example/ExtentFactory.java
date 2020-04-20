package ToNinja.Lesson181_Multiple_Test_Cases_Practical_Example;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "/Users//Eugene//Desktop//report-demo.html";
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Selenium Version", "2.52")
                .addSystemInfo("Platform", "Windows");
        return extent;
    }
}
