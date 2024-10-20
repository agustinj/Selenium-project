package pages;

public class PaginaRecursos extends BasePage {
    
    private String automationSandboxLink = "//a[normalize-space()='Automation Sandbox' and @href]";

    //h3[normalize-space()='Automation Sandbox']

    public PaginaRecursos() {
        super(driver);
    }

    //Método para navegar a Sección SandBox
    public void clickAutomationSandboxLink() {
        clickElement(automationSandboxLink);

        String originalTab = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalTab)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
