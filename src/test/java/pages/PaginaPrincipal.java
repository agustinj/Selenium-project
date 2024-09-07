package pages;

public class PaginaPrincipal extends BasePage {

    private String sectionLink = "//a[normalize-space()='%s' and @href]";

    public PaginaPrincipal() {
        //driver en este caso viene del constructor de la BasePage
        super(driver);
    }
    
    //Método para navegar a FRT
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com/");
    }

    //Método para navegar a Sección
    public void clickOnSectionNavigationBar(String section) {
        //Reemplaza el marcador de posición (%) en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

}
