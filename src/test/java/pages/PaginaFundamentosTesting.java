package pages;

public class PaginaFundamentosTesting extends BasePage {

    private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";
    
    public PaginaFundamentosTesting() {
        super(driver); 
    }

    //Método para navegar a Sección
    public void clickIntroduccionTestingLink() {
        clickElement(introduccionTestingLink);
    }

}
