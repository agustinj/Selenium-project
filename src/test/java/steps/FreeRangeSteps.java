package steps;
 
import io.cucumber.java.en.Given;
import pages.PaginaPrincipal;
 
public class FreeRangeSteps {
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
 
    @Given("I navigate to website")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }
 
}