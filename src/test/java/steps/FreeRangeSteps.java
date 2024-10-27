package steps;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import pages.PaginaRecursos;
import pages.PaginaRegistro;
import pages.PaginaSandbox;
import pages.PaginaFundamentosTesting;
 
public class FreeRangeSteps {
    SoftAssert soft = new SoftAssert();
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosTestingPage = new PaginaCursos();
    PaginaRecursos recursosPage = new PaginaRecursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    PaginaSandbox sandboxPage = new PaginaSandbox();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("I select Introduccion al Testing")
    public void navigateToIntro() {
        cursosTestingPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @When("The client selects Elegir Plan")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }

    @Then("The client can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos", "Academia: $176 / año • 13 productos", "Free: Gratis • 3 productos");

        assertEquals(listaEsperada, lista);
    }

    @Given("The user navigates to the Sandbox page")
    public void userNavigatesToSandbox() {
        landingPage.navigateToFreeRangeTesters();
        landingPage.clickOnSectionNavigationBar("Recursos");
        recursosPage.clickAutomationSandboxLink();
    } 

    @Then("The user verifies the text displayed is correct")
    public void verifyTextDisplayed() {
        String expectedTextDisplayed = "Visita nuestra página en www.freerangetesters.com para obtener más información.";
        String actualText = sandboxPage.getInfoText();
        assertEquals(expectedTextDisplayed, actualText);
    }

    @And("The user verifies the link to FRT")
    public void verifyLink() {
        String expectedLink = "https://www.freerangetesters.com/";
        String actualLink = sandboxPage.getLink();
        assertEquals(expectedLink, actualLink);
    }

    @Given("The user clicks the dynamic button")
    public void userClicksOnDynamicButton() {
        sandboxPage.clickOnElementoOcultoButton();
    }

    @Then("The user verifies the text is displayed after 3 seconds")
    public void verifyTextAfter3Seconds() {
        String expectedText = "OMG, aparezco después de 3 segundos de haber hecho click en el botón 👻.";
        String actualText = sandboxPage.getTextoElementoOculto();
        assertEquals(expectedText, actualText);
    }

    @Given("The user selects all checkboxes")
    public void userClicksOnAllCheckboxes() {
        sandboxPage.selectCheckboxesByIndices(null);
    }

    @Then("The user verifies that all checkboxes are selected")
    public void verifyAllCheckboxesChecked() {
        List<WebElement> checkboxes = sandboxPage.getAllCheckboxes();
        for (WebElement checkbox : checkboxes) {
            assertTrue("Checkbox is not selected", checkbox.isSelected());
        }
    }

    @Given("The user selects the No radio button")
    public void userSelectRadioButton() {
        sandboxPage.selectRadioButton("2");
    }

    @Then("The user verifies that the No radio button is selected")
    public void verifyRadioButtonNoIsSelected() {
        sandboxPage.verifyRadioButtonIsEnabled("2");
    }
}