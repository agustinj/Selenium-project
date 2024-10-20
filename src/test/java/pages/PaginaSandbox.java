package pages;

import org.openqa.selenium.By;

public class PaginaSandbox extends BasePage {

    private String infoTextXpath = "//p[contains(text(),'Visita nuestra página en www.freerangetesters.com')]";

    public PaginaSandbox() {
        super(driver);
    }

    public String getInfoText() {
        return driver.findElement(By.xpath(infoTextExpath)).getText();
    }
}
