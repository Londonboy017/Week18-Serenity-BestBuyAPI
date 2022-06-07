package ui.swagger.steps;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import ui.swagger.constants.EndPoints;

public class UtilitiesSteps {
    @Step("Get the Version")
    public ValidatableResponse getVersion(){

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_VERSION)
                .then();
    }

    @Step("Get the healthCheck")
    public ValidatableResponse getHealthCheck() {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_HEALTHCHECK)
                .then();
    }
}
