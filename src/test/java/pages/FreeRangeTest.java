package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        

        //Inicializa el WebDriver para Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }  

    @Test
    public void navegamosAFreeRangeTesters() {
        //Navega a la página web
        driver.get("https://thefreerangetester.github.io/sandbox-automation-testing/");
    }

    @AfterMethod
    public void tearDown() {
        //Cierra el navegador después de la prueba
        if (driver != null) {
            driver.quit();
        }
    }
}
