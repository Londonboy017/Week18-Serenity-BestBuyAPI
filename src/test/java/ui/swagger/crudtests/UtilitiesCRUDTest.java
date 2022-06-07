package ui.swagger.crudtests;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import ui.swagger.testbase.TestBase;
import ui.swagger.steps.UtilitiesSteps;

import static org.hamcrest.Matchers.hasKey;
@RunWith(SerenityRunner.class)
public class UtilitiesCRUDTest extends TestBase {
    @Steps
    UtilitiesSteps utilitiesSteps;

    @Title("This test will Get the version of Application")
    @Test
    public void getVersion() {
        ValidatableResponse response = utilitiesSteps.getVersion();
        response.log().all().statusCode(200);
    }

    @Title("This test will Get the Health check of Application")
    @Test
    public void getHealthCheck() {
        ValidatableResponse response = utilitiesSteps.getHealthCheck();
        response.log().all().statusCode(200);
    }
}