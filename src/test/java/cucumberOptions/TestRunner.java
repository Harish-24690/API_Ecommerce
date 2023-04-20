package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src//test//java//features",
plugin="json:target/jsonReports/cucumber-report.json",
glue= {"stepDefinitions"})
//,tags="@getOrderDetails"
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	

}
