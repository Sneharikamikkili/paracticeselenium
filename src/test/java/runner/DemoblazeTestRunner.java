package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import stepdefinitions.DemoBlaze_BaseClass;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue={"stepdefinitions"},
        tags = {"@smoke"},
        monochrome = true,
        dryRun = false,
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        format={"pretty","json:target/cucumber-reports/cucumber.json"}


)



public class DemoblazeTestRunner {

    @BeforeClass
    public static void configread() throws IOException {
        DemoBlaze_BaseClass demoBlaze_baseClass = new DemoBlaze_BaseClass();
        demoBlaze_baseClass.executionproperties();
    }

    @AfterClass
    public static void closebrowser()
    {
        DemoBlaze_BaseClass.wdriver.close();
    }

}
