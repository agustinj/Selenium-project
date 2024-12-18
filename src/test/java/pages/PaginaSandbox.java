package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PaginaSandbox extends BasePage {

    private String infoTextXpath = "//p[contains(., 'Visita nuestra página en') and contains(., 'www.freerangetesters.com')]";
    private String botonOcultoXpath = "//button[contains(text(),'Hacé click para generar un ID dinámico y mostrar el elemento oculto')]";
    private String textoElementoOculto = "//p[contains(text(),'OMG, aparezco después de 3 segundos')]";
    private String mostrarPopUp = "//button[contains(text(),'Mostrar popup')]";
    private String textoPopup = "//p[normalize-space()='¿Viste? ¡Apareció un Pop-up!']";
    private String cerrarPopup = "//button[contains(text(),'Cerrar')]";
    
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
    
    public void selectRadioButton(String labelText) {
        // Locate the radio button associated with the provided label text
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='formRadio" + labelText + "']"));
        
        // Scroll the radio button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
    
        // Use JavaScript to click the radio button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
    
        // Check if the radio button is selected
        if (!radioButton.isSelected()) {
            radioButton.click(); // Click to select the radio button if not already selected
        }
    }

    public void verifyRadioButtonIsEnabled(String radioButtonValue) {
        // Locate the radio button using its value
        // WebElement radioButton = driver.findElement(By.xpath("//input[@type='formRadio' and @value='" + radioButtonValue + "']"));
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='formRadio" + radioButtonValue + "']"));

        // Check if the radio button is selected
        boolean isSelected = radioButton.isSelected();

        // Assert that it is selected
        Assert.assertTrue("The radio button with value '" + radioButtonValue + "' should be selected.", isSelected);
    }


    public void clickOnMostrarPopUp() {
        // Locate the mostrar popup button using the XPath defined at the top
        WebElement mostrarPopUpElement = driver.findElement(By.xpath(mostrarPopUp));
    
        // Check if the element is displayed
        if (mostrarPopUpElement.isDisplayed()) {
            // Scroll the mostrar popup button into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mostrarPopUpElement);
            
            // Use JavaScript to click the button
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mostrarPopUpElement);
        } else {
            System.out.println("Mostrar PopUp button is not visible.");
        }
    }

    public String getTextoPopupEjemplo() {
        return getElementText(textoPopup);
    }

    public void clickOnCerrarButton() {
        clickElement(cerrarPopup);
    }

    public List<String> getValuesFromDynamicTable() {
        List<String> values = new ArrayList<>();
        List<WebElement> cells = driver.findElements(By.xpath("//h2[normalize-space()='Tabla dinámica']/following-sibling::table[1]/tbody/tr/td"));

        for (WebElement cell : cells) {
            String cellText = cell.getText().trim(); // Trim whitespace
            System.out.println("Extracted cell text: '" + cellText + "'");
            values.add(cellText);
        }
        return values;
    }

    public List<List<String>> getStaticTableData() {
        List<List<String>> data = new ArrayList<>();
        List<WebElement> rows = driver.findElements(By.xpath("//h2[normalize-space()='Tabla estática']/following-sibling::table/tbody/tr")); // Adjust the XPath as necessary
    
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();
    
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            data.add(rowData);
        }
        return data;
    }

    public void verifyTableHeadersAreCorrect(List<String> expectedHeaders) {
        // Create a list to hold actual header values
        List<String> actualHeaders = new ArrayList<>();
        
        // Fetch header elements using the relative XPath
        for (String header : expectedHeaders) {
            WebElement headerElement = driver.findElement(By.xpath("//th[normalize-space()='" + header + "']"));
            actualHeaders.add(headerElement.getText());
        }
        
        // Check that the actual headers match the expected headers
        Assert.assertEquals("Headers do not match!", expectedHeaders, actualHeaders);
    }
}

