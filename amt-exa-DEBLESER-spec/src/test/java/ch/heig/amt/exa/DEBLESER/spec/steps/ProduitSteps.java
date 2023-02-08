package ch.heig.amt.exa.DEBLESER.spec.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.api.ProduitsEndPointApi;
import org.openapitools.client.model.Produit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProduitSteps {

    private final ProduitsEndPointApi api = new ProduitsEndPointApi();
    private Produit produit;
    private int statusCode;
    private String url;


    @Given("I have a product payload")
    public void iHaveAProductPayload() {
        produit = new Produit();
        produit.setPrdNum(7);
        produit.setDescription("description test");
        produit.setPoids(50);
        produit.statusLivraison("en cours");
        produit.setVilNum(1);
    }

    @When("I POST it to the \\/produits endpoint")
    public void iPOSTItToTheProduitsEndpoint() {
        try {
            ApiResponse response = api.addProduitWithHttpInfo(produit);
            statusCode = response.getStatusCode();
            url = response.getData().toString();
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @Then("I receive a {int} status code")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(arg1, statusCode);
    }


    @When("I GET it thru the given Id")
    public void iGETItThruTheGivenId(int arg1) {
        try {
            produit = api.getProduit(arg1);
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @Then("The descriptions corresponds to the created one")
    public void theDescriptionsCorrespondsToTheCreatedOne(Produit created, Produit check) {
        assertEquals(created.getDescription(), check.getDescription());
    }

    @Then("The weight corresponds to the created one")
    public void theWeightCorrespondsToTheCreatedOne(Produit created, Produit check) {
        assertEquals(created.getPoids(), check.getPoids());
    }

    @Then("The delivery city corresponds to the created one")
    public void theDeliveryCityCorrespondsToTheCreatedOne(Produit created, Produit check) {
        assertEquals(created.getVilNum(), check.getVilNum());
    }

    @Then("I receive a url pointing to that product")
    public void iReceiveAUrlPointingToThatProduct() {
        assertEquals("/products/7", url);
    }
}
