package ui.swagger.cucumber.stepsinfo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.commons.io.input.TeeInputStream;
import org.junit.runner.RunWith;
import ui.swagger.testbase.TestBase;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/featurefile/",
//glue = "src/test/java/ui/swagger/",
tags = {})
public class CucumberRunner extends TestBase {


}
