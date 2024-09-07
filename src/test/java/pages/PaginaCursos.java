package pages;

public class PaginaCursos extends BasePage {

    private String fundamentosTestingLink = "//a[normalize-space()='Fundamentos del Testing' and @href]";
    
    public PaginaCursos() {
        super(driver);
    }

    //Método para navegar a Sección
    public void clickFundamentosTestingLink() {
        clickElement(fundamentosTestingLink);
    }

}
