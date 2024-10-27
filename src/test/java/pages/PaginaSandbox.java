package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaSandbox extends BasePage {

    private String infoTextXpath = "//p[contains(., 'Visita nuestra página en') and contains(., 'www.freerangetesters.com')]";
    private String botonOcultoXpath = "//button[contains(text(),'Hacé click para generar un ID dinámico y mostrar el elemento oculto')]";
    private String textoElementoOculto = "//p[contains(text(),'OMG, aparezco después de 3 segundos')]";


    public PaginaSandbox() {
        super(driver);
    }

    public String getInfoText() {
        return getElementText(infoTextXpath);
    }

    public String getLink() {
        return getLink("www.freerangetesters.com");
    }

    public void clickOnElementoOcultoButton() {
        clickElement(botonOcultoXpath);
    }

    public String getTextoElementoOculto() {
        return getElementText(textoElementoOculto);
    }

    public void selectCheckboxesByIndices(List<Integer> indices) {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // If indices is null, select all checkboxes
        if (indices == null || indices.isEmpty()) {
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        } else {
            // Select only specified checkboxes
            for (int index : indices) {
                if (index >= 0 && index < checkboxes.size() && !checkboxes.get(index).isSelected()) {
                checkboxes.get(index).click();
                }
            }
        }
    }

    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(By.xpath("//input[@type='checkbox']"));
    }
}
