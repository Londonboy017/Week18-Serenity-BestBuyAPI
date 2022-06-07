package ui.swagger.cucumber.stepsinfo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import ui.swagger.steps.ProductsStep;
import ui.swagger.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ProductsStepdef {
    static String name = "Prime_Battery" + TestUtils.getRandomValue();
    static String type = "lithium";
    static int price = 4;
    static Integer shipping = 12;
    static String upc = "DHL";
    static String description = "Solar charge";
    static String manufacturer = "TeslaBattery";
    static String model = "MAKE2019";
    static String url = "jay_battery.com";
    static String image = "jay.png";
    static int productID;
    ValidatableResponse response;
    @Steps
    ProductsStep productsStep;

    @When("^user sends a POST request to products endpoint$")
    public void userSendsAPOSTRequestToProductsEndpoint() {
        response = productsStep.createANewProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image).log().all();
        productID = response.log().all().extract().path("id");
    }

    @When("^user sends a PATCH request to productsID endpoint$")
    public void userSendsAPATCHRequestToProductsIDEndpoint() {
        name = name + "_updated";
        response = productsStep.updateProduct(productID, name);

    }

    @Then("^User must get back a valid status code (\\d+) from products endpoint$")
    public void userMustGetBackAValidStatusCodeFromProductsEndpoint(int arg0) {
        response.statusCode(201);
    }

    @And("^User verify newly added product name in record$")
    public void userVerifyNewlyAddedProductNameInRecord() {
        HashMap<String, Object> productMap = productsStep.getProductInfoByName(productID);
        Assert.assertThat(productMap, hasValue(name));
    }

    @Then("^User must get back valid status code (\\d+) from products endpoint$")
    public void userMustGetBackValidStatusCodeFromProductsEndpoint(int arg0) {
        response.statusCode(200).log().all();
    }

    @And("^User verify updated product name in record$")
    public void userVerifyUpdatedProductNameInRecord() {
        HashMap<String, Object> productMapData = productsStep.getSingleProductData(productID);
        Assert.assertThat(productMapData, hasValue(name));
    }

    @When("^user sends a DELETE request to productsID endpoint$")
    public void userSendsADELETERequestToProductsIDEndpoint() {
        response = productsStep.deleteSingleProduct(productID);
    }

    @Then("^User must get back valid status code (\\d+) from products$")
    public void userMustGetBackValidStatusCodeFromProducts(int arg0) {
        response.statusCode(200);

    }

    @And("^User verify deleted product name not found in record$")
    public void userVerifyDeletedProductNameNotFoundInRecord() {
        productsStep.getSingleProduct(productID).statusCode(404).log().all();
    }

    @When("^user sends a GET request to productsID endpoint$")
    public void userSendsAGETRequestToProductsIDEndpoint() {
      response=  productsStep.getSingleProduct(productID);
    }

    @And("^User verify product name in record$")
    public void userVerifyProductNameInRecord() {
        HashMap<String, Object> productMap =  productsStep.getProductInfoByName(productID);
        Assert.assertThat(productMap, hasValue(name));
    }

    @Then("^User must get back valid status code (\\d+) from product$")
    public void userMustGetBackValidStatusCodeFromProduct(int arg0) {
        response.assertThat().statusCode(200);
    }
}
