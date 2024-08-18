package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", //Directorio de archivos .feature
    glue = "steps", //Paquete donde tenemos clases definiendo los steps del feature file
    plugin = { "pretty", "html:target/cucumber-reports" })

public class TestRunner {
    
}
