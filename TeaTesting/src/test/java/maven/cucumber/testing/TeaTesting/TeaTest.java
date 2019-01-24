package maven.cucumber.testing.TeaTesting;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Administrator\\eclipse-workspace\\TeaTesting\\src\\test\\java\\TeaTesting.feature")

public class TeaTest {
	public static ExtentReports report;
	
	@BeforeClass
	public static void setup() {
		report = new ExtentReports(Constant.pathTestData + Constant.fileTestData);	}
	
	@AfterClass
	public static void teardown() {
		report.flush();}
}
