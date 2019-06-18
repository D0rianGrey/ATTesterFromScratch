package ToNinja.Lesson182_Reproducing_With_Page_Object_Model;

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
